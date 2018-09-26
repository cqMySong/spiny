package com.gioov.spiny.system.api;

import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.system.entity.ViewPageComponentApiEntity;
import com.gioov.spiny.system.mapper.ViewPageComponentApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(Api.System.VIEW_PAGE_COMPONENT_API)
public class ViewPageComponentApiRestController {

    private static final String VIEW_PAGE_COMPONENT_API = "/API/SYSTEM/VIEW_PAGE_COMPONENT_API";

    @Autowired
    private ViewPageComponentApiMapper viewPageComponentApiMapper;

    /**
     * 是否关联 API
     *
     * @param pageComponentId 视图页面组件 id
     * @param apiId API id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_COMPONENT_API + "/IS_ASSOCIATED_BY_PAGE_COMPONENT_ID_AND_API_ID')")
    @RequestMapping(value = "/is_associated_by_page_component_id_and_api_id", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> isAssociatedByPageComponentIdAndApiId(@RequestParam Long pageComponentId, @RequestParam Long apiId) {
        Map<String, Object> data = new HashMap<>(1);
        data.put("isAssociated", false);

        try {
            ViewPageComponentApiEntity viewPageComponentApiEntity = viewPageComponentApiMapper.getOneByPageComponentIdAndApiId(pageComponentId, apiId);

            if (viewPageComponentApiEntity != null) {
                data.put("isAssociated", true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    /**
     * 批量关联 API
     *
     * @param pageComponentId 视图页面组件 id
     * @param apiIdList API id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_COMPONENT_API + "/ASSOCIATE_ALL_BY_PAGE_COMPONENT_ID_AND_API_ID_LIST')")
    @RequestMapping(value = "/associate_all_by_page_component_id_and_api_id_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> associateAllByPageComponentIdAndApiIdList(@RequestParam Long pageComponentId, @RequestParam("apiIdList[]") List<Long> apiIdList) {

        List<Long> apiIdList2 = new ArrayList<>();
        ViewPageComponentApiEntity viewPageComponentApiEntity = null;

        try {
            for (Long apiId : apiIdList) {
                viewPageComponentApiEntity = viewPageComponentApiMapper.getOneByPageComponentIdAndApiId(pageComponentId, apiId);
                if (viewPageComponentApiEntity == null) {
                    apiIdList2.add(apiId);
                }
            }

            if (!apiIdList2.isEmpty()) {
                viewPageComponentApiMapper.insertAllByPageComponentIdAndApiIdList(pageComponentId, apiIdList2);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiIdList2, HttpStatus.OK);
    }

    /**
     * 指定视图页面组件 id、API id ，批量撤销关联
     *
     * @param pageComponentId 视图页面组件 id
     * @param apiIdList API id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_COMPONENT_API + "/REVOKE_ALL_BY_ROLE_ID_AND_AUTHORITY')")
    @RequestMapping(value = "/revoke_associate_all_by_page_component_id_and_api_id_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> revokeAssociateAllByPageComponentIdAndApiIdList(@RequestParam Long pageComponentId, @RequestParam("apiIdList[]") List<Long> apiIdList) {
        int result = 0;
        try {
            if (!apiIdList.isEmpty()) {
                viewPageComponentApiMapper.deleteAllByPageComponentIdAndApiIdList(pageComponentId, apiIdList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
