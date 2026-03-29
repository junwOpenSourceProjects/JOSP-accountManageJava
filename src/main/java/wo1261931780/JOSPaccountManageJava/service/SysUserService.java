package wo1261931780.JOSPaccountManageJava.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import wo1261931780.JOSPaccountManageJava.entity.SysUser;

/**
 * 用户Service
 * @author junw
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 分页查询用户
     */
    Page<SysUser> page(Integer page, Integer limit, String username, Integer status);

    /**
     * 根据用户名查询用户
     */
    SysUser getByUsername(String username);
}
