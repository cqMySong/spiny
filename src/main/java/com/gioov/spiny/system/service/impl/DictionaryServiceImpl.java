package com.gioov.spiny.system.service.impl;

import com.gioov.spiny.system.entity.DictionaryEntity;
import com.gioov.spiny.system.mapper.DictionaryMapper;
import com.gioov.spiny.system.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    @Override
    @Deprecated
    public void addDictionaryToModelAndView(ModelAndView modelAndView) {
        if (modelAndView != null) {
            modelAndView.addAllObjects(keyValueMap());
        }
    }

    @Override
    public void addDictionaryToServletContext() {
        ServletContext servletContext = webApplicationContext.getServletContext();
        if (servletContext != null) {

            List<DictionaryEntity> dictionaryEntityList = dictionaryMapper.listAll();
            if (dictionaryEntityList != null) {
                for (DictionaryEntity dictionaryEntity : dictionaryEntityList) {
                    servletContext.setAttribute(dictionaryEntity.getKey().toUpperCase() + "." + dictionaryEntity.getValueSlug().toUpperCase(), dictionaryEntity.getValue());
                }


                Map<String, List<DictionaryEntity>> dictionaryEntityMap = new HashMap<>(6);
                for (DictionaryEntity dictionaryEntity : dictionaryEntityList) {
                    String key = dictionaryEntity.getKey().toUpperCase();
                    if (dictionaryEntityMap.containsKey(key)) {
                        List<DictionaryEntity> dictionaryEntityList1 = dictionaryEntityMap.get(key);
                        if (!dictionaryEntityList1.contains(dictionaryEntity)) {
                            dictionaryEntityList1.add(dictionaryEntity);
                            dictionaryEntityMap.put(key, dictionaryEntityList1);
                        }
                    } else {
                        List<DictionaryEntity> dictionaryEntityList2 = new ArrayList<>(1);
                        dictionaryEntityList2.add(dictionaryEntity);
                        dictionaryEntityMap.put(key, dictionaryEntityList2);
                    }
                }

                for (Map.Entry entry : dictionaryEntityMap.entrySet()) {
                    servletContext.setAttribute((String) entry.getKey(), entry.getValue());
                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    private String getValueByKeyAndValueSlug(String key, String valueSlug) {

        ServletContext servletContext = webApplicationContext.getServletContext();
        if (servletContext != null) {
            return (String) servletContext.getAttribute(key + "." + valueSlug);
        } else {
            return null;
        }
    }

    @Override
    public String get(String key, String valueSlug) {
        return getValueByKeyAndValueSlug(key, valueSlug);
    }

    @Override
    public String get(String key, String valueSlug, String defaultValue) {
        String v = getValueByKeyAndValueSlug(key, valueSlug);
        if (v != null) {
            return v;
        }
        return defaultValue;
    }

    @Override
    public Map<String, Map<String, Object>> keyValueMap() {
        Map<String, Map<String, Object>> mapMap = new HashMap<>(6);
        List<DictionaryEntity> dictionaryEntityList = dictionaryMapper.listAll();
        if (dictionaryEntityList != null) {
            for (DictionaryEntity dictionaryEntity : dictionaryEntityList) {
                if (mapMap.containsKey(dictionaryEntity.getKey())) {
                    Map<String, Object> valueMap = mapMap.get(dictionaryEntity.getKey());
                    if (!valueMap.containsKey(dictionaryEntity.getValueSlug())) {
                        valueMap.put(dictionaryEntity.getValueSlug(), dictionaryEntity.getValue());
                    }
                    mapMap.put(dictionaryEntity.getKey(), valueMap);
                } else {
                    Map<String, Object> valueMap = new HashMap<>(1);
                    valueMap.put(dictionaryEntity.getValueSlug(), dictionaryEntity.getValue());
                    mapMap.put(dictionaryEntity.getKey(), valueMap);
                }
            }
        }

        return mapMap;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DictionaryEntity> listAllByKey(String key) {
        return (List<DictionaryEntity>) webApplicationContext.getServletContext().getAttribute(key);
    }

}
