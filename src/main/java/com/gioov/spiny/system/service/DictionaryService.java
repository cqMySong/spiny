package com.gioov.spiny.system.service;

import com.gioov.spiny.system.entity.DictionaryEntity;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public interface DictionaryService {

    /**
     * 低效：添加数据字典到 ModelAndView
     *
     * @param modelAndView ModelAndView
     */
    void addDictionaryToModelAndView(ModelAndView modelAndView);

    /**
     * 高效：添加数据字典到 ServletContext（内存）
     */
    void addDictionaryToServletContext();

    /**
     * 获取数据字典值
     *
     * @param key 数据字典键
     * @param valueSlug 数据字典值别名
     * @return 数据字典值
     */
    String get(String key, String valueSlug);

    /**
     * 获取数据字典值
     *
     * @param key 数据字典键
     * @param valueSlug 数据字典值别名
     * @param defaultValue 数据字典默认值
     * @return 数据字典值
     */
    String get(String key, String valueSlug, String defaultValue);

    /**
     * 将数据字典包装成 map
     *
     * @return Map<String, Map<String, Object>>
     */
    Map<String, Map<String, Object>> keyValueMap();

    /**
     * 指定数据字典键，获取所有数据字典
     *
     * @param key 数据字典键
     * @return List<DictionaryEntity>
     */
    List<DictionaryEntity> listAllByKey(String key);

}
