package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Admin;
import com.property.management.entity.Device;
import com.property.management.entity.Role;
import com.property.management.entity.User;
import com.property.management.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
@Controller
@RequestMapping("admin")
//定义了一个名为admincontroller的MVC控制器，用于处理与后台管理员相关的HTTP请求
// 该控制器包含多个方法，每个方法都通过@RequestMapping注解映射到特定的URL路径
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("admin_list")
    //显示管理员列表。它接受一个username，用于按用户名搜索管理员。该方法使用PageHelper进行分页处理，并从AdminService获取管理员列表和总数
    // 然后，它将这些数据添加到模型中，并返回视图名"mannage/adminList"以呈现管理员列表页面。
    public String admin_list(String username, Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Admin> admins = adminService.queryByName(username);
        model.addAttribute("username",username);
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = adminService.queryByNameCount(username);
        model.addAttribute("adminList", admins);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "mannage/adminList";
    }
    @RequestMapping("deleteAdminlById")
    @ResponseBody
    //@ResponseBody注解表示该方法返回的对象将直接作为HTTP响应体返回，而不是解析为视图名。
    //删除指定id的管理员
    public Object deleteAdminlById(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.deleteAdminlById(id);
        if(b){
            map.put("code",200);
            map.put("info","删除成功");
        }else {
            map.put("code",500);
            map.put("info","删除失败");
        }
        return map;
    }
    @RequestMapping("deleteAdminByIds/{ids}")
    @ResponseBody
    //批量删除管理员
    public Object deleteAdminByIds(@PathVariable("ids") String ids){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.deleteAdminByIds(ids);
        if(b){
            map.put("code",200);
            map.put("info","批量删除成功");
        }else {
            map.put("code",500);
            map.put("info","批量删除失败");
        }
        return map;
    }
    @RequestMapping("admin_add")
    //显示添加管理员的表单页面
    public String admin_add(Model model){
        List<Role> roles = adminService.queryRoleInfo();
        model.addAttribute("rolelist",roles);
        return "mannage/adminAdd";
    }
    @RequestMapping("adminInsert")
    @ResponseBody
    //处理添加管理员的表单提交
    public Object adminInsert(User user){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.adminInsert(user);
        if(b){
            map.put("code",200);
            map.put("info","添加成功");
        }else {
            map.put("code",500);
            map.put("info","添加失败");
        }
        return map;
    }
    @RequestMapping("admin_edit")
    //显示编辑管理员的表单页面
    public String admin_edit(Integer id,Model model){
        Admin admin = adminService.queryAdminById(id);
        List<Role> roles = adminService.queryRoleInfo();
        model.addAttribute("admin",admin);
        model.addAttribute("rolelist",roles);
        return "mannage/adminEdit";
    }
    @RequestMapping("updateAdmin")
    @ResponseBody
    //处理编辑管理员的表单提交
    public Object updateAdmin(User user){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.updateAdmin(user);
        if(b){
            map.put("code",200);
            map.put("info","编辑成功");
        }else {
            map.put("code",500);
            map.put("info","编辑失败");
        }
        return map;
    }
    @RequestMapping("usernameCheck")
    @ResponseBody
    public Object usernameCheck(String name){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.usernameCheck(name);
        if(b){
            map.put("code",200);
            map.put("info","该用户名已被使用");
        }else {
            map.put("code",500);
            map.put("info","该用户名可以使用");
        }
        return map;
    }
}
