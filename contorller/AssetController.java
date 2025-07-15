package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Asset;
import com.property.management.entity.Charge;
import com.property.management.service.AssetService;
import com.property.management.util.LayUtil;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
//定义了一个名为AssetController的Spring MVC控制器，它处理与资产Assets相关的HTTP请求。
// 这个控制器通过@Controller注解标识，并使用@RequestMapping("asset")来指定所有这个控制器处理的请求URL的前缀为/asset
//主要通过调用AssetService服务层的方法来实现，并将结果返回给客户端。
@Controller
@RequestMapping("asset")
public class AssetController {
    @Autowired
    private AssetService assetService;
    @RequestMapping("assetList")
    public String assetList(String rateName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Asset> assets= assetService.queryByName(rateName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("rateName",rateName);
        PageInfo<Asset> pageInfo = new PageInfo<>(assets);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = assetService.queryByNameCount(rateName, startTime, endTime);
        model.addAttribute("assetList", assets);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "asset/asset_list";
    }
    //处理根据ID删除单个资产的请求
    @RequestMapping("deleteAssetById")
    @ResponseBody
    public Object deleteAssetById(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = assetService.deleteAssetById(id);//调用assetService.deleteAssetById方法删除指定ID的资产
        if(b){
            map.put("code",200);
            map.put("info","删除一条记录");
        }else{
            map.put("code",500);
            map.put("info","删除失败");
        }
        return map;
    }
    //批量删除资产
    @RequestMapping("deleteAssetByIds/{ids}")
    public Object deleteAssetByIds(@PathVariable("ids") String ids){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = assetService.deleteAssetByIds(ids);//assetService.deleteAssetByIds方法批量删除资产
        if(b){
            map.put("code",200);
            map.put("info","批量删除成功");
        }else{
            map.put("code",500);
            map.put("info","批量删除失败");
        }
        return map;
    }
    @RequestMapping("assetEdit")
    public String assetEdit(Integer id,Model model){
        Asset asset = assetService.queryAssetInfoById(id);
        List<Charge> charges = assetService.qyeryAll();//调用assetService.qyeryAll方法获取所有费用信息
        //然后将这些信息添加到模型中并返回视图名"asset/asset_edit"
        model.addAttribute("charges",charges);
        model.addAttribute("asset",asset);
        return "asset/asset_edit";
    }
    @RequestMapping("updateAsset")
    @ResponseBody
    public Object updateAsset(Asset asset){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = assetService.updateAsset(asset);
        if(b){
            map.put("code",200);
            map.put("info","更新成功");
        }else{
            map.put("code",500);
            map.put("info","更新失败");
        }
        return map;
    }
    @RequestMapping("selectRate")
    @ResponseBody
    public Object selectRate(String cName,Model model) {
        System.out.println(cName);
        List<Charge> cha = assetService.selectRate(cName);
        return cha;
    }
    @RequestMapping("assetAdd")
    public String assetAdd(Model model){
        List<Charge> charges = assetService.qyeryAll();
        model.addAttribute("charges",charges);
        return "asset/asset_add";
    }
    @RequestMapping("insertAsset")
    @ResponseBody
    public Object insertAsset(Asset asset){
        HashMap<String, Object> map = new HashMap<>();
        boolean b = assetService.insertAsset(asset);
        if(b){
            map.put("code",200);
            map.put("info","插入成功");
        }else {
            map.put("code",500);
            map.put("info","插入失败");
        }
        return map;
    }
}
