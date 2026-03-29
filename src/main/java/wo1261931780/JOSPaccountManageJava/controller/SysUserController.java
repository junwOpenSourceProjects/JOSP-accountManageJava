package wo1261931780.JOSPaccountManageJava.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wo1261931780.JOSPaccountManageJava.config.ShowResult;
import wo1261931780.JOSPaccountManageJava.entity.SysUser;
import wo1261931780.JOSPaccountManageJava.service.SysUserService;

/**
 * 用户管理控制器
 * @author junw
 */
@Tag(name = "用户管理", description = "用户管理相关接口")
@RestController
@RequestMapping("/api/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页查询用户
     */
    @Operation(summary = "分页查询用户")
    @GetMapping("/page")
    public ShowResult<Page<SysUser>> page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer status
    ) {
        Page<SysUser> result = sysUserService.page(page, limit, username, status);
        return ShowResult.sendSuccess(result);
    }

    /**
     * 根据ID查询用户
     */
    @Operation(summary = "根据ID查询用户")
    @GetMapping("/{id}")
    public ShowResult<SysUser> getById(@PathVariable Long id) {
        SysUser user = sysUserService.getById(id);
        return ShowResult.sendSuccess(user);
    }

    /**
     * 新增用户
     */
    @Operation(summary = "新增用户")
    @PostMapping
    public ShowResult<String> save(@RequestBody SysUser user) {
        boolean success = sysUserService.save(user);
        if (success) {
            return ShowResult.sendSuccess(null, "新增成功");
        }
        return ShowResult.sendError("新增失败");
    }

    /**
     * 更新用户
     */
    @Operation(summary = "更新用户")
    @PutMapping
    public ShowResult<String> update(@RequestBody SysUser user) {
        boolean success = sysUserService.updateById(user);
        if (success) {
            return ShowResult.sendSuccess(null, "更新成功");
        }
        return ShowResult.sendError("更新失败");
    }

    /**
     * 删除用户
     */
    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public ShowResult<String> delete(@PathVariable Long id) {
        boolean success = sysUserService.removeById(id);
        if (success) {
            return ShowResult.sendSuccess(null, "删除成功");
        }
        return ShowResult.sendError("删除失败");
    }

    /**
     * 批量删除用户
     */
    @Operation(summary = "批量删除用户")
    @DeleteMapping("/batch")
    public ShowResult<String> deleteBatch(@RequestBody Long[] ids) {
        for (Long id : ids) {
            sysUserService.removeById(id);
        }
        return ShowResult.sendSuccess(null, "批量删除成功");
    }
}
