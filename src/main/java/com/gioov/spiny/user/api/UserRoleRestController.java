package com.gioov.spiny.user.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.user.entity.UserRoleEntity;
import com.gioov.spiny.user.mapper.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(value = Api.User.USER_ROLE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserRoleRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleRestController.class);

    private static final String USER_ROLE = "/API/USER/USER_ROLE";

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 分页获取所有用户角色
     *
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER_ROLE + "/PAGE_ALL')")
    @RequestMapping(value = "/page_all", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAll(@RequestParam Integer page, @RequestParam Integer rows) {
        List<UserRoleEntity> userRoleEntityList = null;
        Pagination.Result<UserRoleEntity> paginationResult = new Pagination().new Result<>();

        try {
            userRoleEntityList = userRoleMapper.pageAll(new Pageable(page, rows));
            if (userRoleEntityList != null) {
                paginationResult.setRows(userRoleEntityList);
            }
            int count = userRoleMapper.countAll();
            paginationResult.setTotal(count);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }


    /**
     * 新增用户角色
     *
     * @param userId 用户 id
     * @param roleId 角色 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER_ROLE + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam Long userId, @RequestParam Long roleId) {
        UserRoleEntity userRoleEntity = null;
        try {
            userRoleEntity = userRoleMapper.getOneByUserIdAndRoleId(userId, roleId);

            if (userRoleEntity != null) {
                throw new BaseResponseException("授权失败，该角色已授权");
            }
            userRoleEntity = new UserRoleEntity();
            userRoleEntity.setUserId(userId);
            userRoleEntity.setRoleId(roleId);
            userRoleMapper.insertOne(userRoleEntity);

        } catch (BaseResponseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(e), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(userRoleEntity, HttpStatus.OK);
    }

//    /**
//     * 删除用户角色
//     *
//     * @param id
//     * @return ResponseEntity<? extends Object>
//     */
//    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER_ROLE + "/DELETE_ONE')")
//    @RequestMapping(value = "/delete_one", method = RequestMethod.POST)
//    public ResponseEntity<? extends Object> deleteOne(@RequestParam Long id) {
//        int result = 0;
//        try {
//            result = userRoleMapper.deleteOne(id);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    /**
     * 指定用户角色 id ，批量删除用户角色
     *
     * @param roleIdList 角色 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER_ROLE + "/DELETE_ALL_BY_USER_ID_AND_ROLE_ID_LIST')")
    @RequestMapping(value = "/delete_all_by_user_id_and_role_id_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("roleIdList[]") List<Long> roleIdList, @RequestParam("userId") Long userId) {
        int result = 0;
        try {
            result = userRoleMapper.deleteAllByUserIdAndRoleIdList(userId, roleIdList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
