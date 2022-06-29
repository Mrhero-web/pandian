package com.ams.controller;

import com.alibaba.fastjson.JSONObject;
import com.ams.domain.*;
import com.ams.service.IAssetInventoryService;
import com.ams.service.IAssetService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/assetInventory")

public class AssetInventoryController {
    @Autowired
    private IAssetInventoryService assetInventoryService;
    @Autowired
    private IAssetService assetService;
    HttpSession session;

    @RequestMapping("/deleteById.do")
    public String deleteById(Integer id) throws Exception {
        System.out.println(id);
        assetInventoryService.deleteInventory(id);
        return "redirect:findAllSend.do?page=1&size=10";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "10")  Integer size,
                                @RequestParam(name = "conditions", required = true, defaultValue = "") String conditions,
                                @RequestParam(name = "orderbys", required = true, defaultValue = "") String orderbys,

                                HttpServletRequest request)  throws Exception {
        ModelAndView mv = new ModelAndView();
       /* session=request.getSession();
        System.out.println(orderbys);

        if(conditions.equals("")){
            conditions= (String) session.getAttribute("condition");
        }else{
            session.setAttribute("condition",conditions);
        }
        if(orderbys.equals("")){
            orderbys= (String) session.getAttribute("orderbys");
        }else{
            session.setAttribute("orderbys",orderbys);
        }
        System.out.println("这是ordrebys啊:"+orderbys);
        System.out.println("这是Condition啊:"+conditions);
        List<Asset> assetList = assetService.findAll(page, size,conditions,orderbys);
        for (Asset good : assetList) {
            System.out.println(good);
        }*/

        //PageInfo就是一个分页Bean
        List<AssetInventory> assetInventoryList = assetInventoryService.findAll(page, size,conditions,orderbys);
        PageInfo pageInfo = new PageInfo(assetInventoryList);


        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("assetInventory-page-list");
        return mv;
    }
    @RequestMapping("/findAllReceive.do")
    public ModelAndView findAllReceive(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                       @RequestParam(name = "size", required = true, defaultValue = "10")  Integer size,
                                       @RequestParam(name = "checkerId", required = false) Integer checkerId,
                                       @RequestParam(name = "checkStatus", required = false) Integer checkStatus,
                                       HttpServletRequest request)  throws Exception {
        ModelAndView mv = new ModelAndView();
        List<AssetInventory> assetList = null;
        PageInfo pageInfo = null;
        assetList = assetInventoryService.findAllReceive(page, size,checkerId,checkStatus);
        pageInfo= new PageInfo(assetList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("assetInventory-page-list");
        return mv;
    }
//, defaultValue = "1"
//@RolesAllowed("ROLE_User")
    @RequestMapping("/findAllSend.do")
    public ModelAndView findAllSend(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                    @RequestParam(name = "size", required = true, defaultValue = "10")  Integer size,
                                    @RequestParam(name = "senderId", required = false, defaultValue = "1") Integer senderId,
                                    @RequestParam(name = "checkStatus", required = false, defaultValue = "0") Integer checkStatus,
                                    HttpServletRequest request)  throws Exception {
        ModelAndView mv = new ModelAndView();

        List<AssetInventory> assetAllotList = null;
        PageInfo pageInfo = null ;
        assetAllotList = assetInventoryService. findAllSend(page, size,senderId,checkStatus);
        pageInfo= new PageInfo(assetAllotList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("assetInventory-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true, defaultValue = "") Integer id,
                                HttpServletRequest request)  throws Exception {
        ModelAndView mv = new ModelAndView();
        session=request.getSession();
        AssetInventory assetInventory = null;
        assetInventory = assetInventoryService.findByInventoryId(id);
        mv.addObject("orders", assetInventory);
        mv.setViewName("assetInventory-show");
        return mv;
    }

    @RequestMapping("/findByAssetId.do")
    public ModelAndView findByAssetId(@RequestParam(name = "id", required = true, defaultValue = "") Integer id,
                                HttpServletRequest request)  throws Exception {
        ModelAndView mv = new ModelAndView();
        session=request.getSession();
        AssetInventory assetInventory = null;
        assetInventory = assetInventoryService.findByAssetId(id);
        mv.addObject("orders", assetInventory);
        //mv.setViewName("assetInventory-page-list");
        mv.setViewName("assetInventory-show");
        return mv;
    }
    @ResponseBody
    @RequestMapping("/findByCode.do")
    public String findCode(@RequestParam(name = "code", required = true, defaultValue = "") String code,
                                HttpServletRequest request)  throws Exception {

        Asset asset=assetService.findByCode(code);
        AssetInventory assetInventory =assetInventoryService.findByAssetId(asset.getId());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("state",true);
        jsonObject.put("data", assetInventory);
        return jsonObject.toJSONString();
    }


    @ResponseBody
    @RequestMapping(value = "/addInventory.do")
    public String mobileFindAll(@RequestBody AssetInventory assetInventory) throws Exception {
        System.out.println(assetInventory);
        assetInventory.setCreatTime(new Date());
        JSONObject jsonObject=new JSONObject();
        if(assetInventoryService.addInventory(assetInventory) && assetService.changeStatus(assetInventory.getId(),4)){
            jsonObject.put("state",true);
        }else{
            jsonObject.put("state",false);

        }
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/updateInventory.do")
    public String updateAll(@RequestBody AssetInventory assetInventory) throws Exception {
        System.out.println(assetInventory);
        JSONObject jsonObject=new JSONObject();
        if(assetInventoryService.updateInventory(assetInventory)){
            jsonObject.put("state",true);
        }else{
            jsonObject.put("state",false);

        }
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/changeCheckStatus.do")
    public String changeCheckStatus(@RequestBody HashMap<String, String> map) throws Exception {

        JSONObject jsonObject=new JSONObject();
        if(assetInventoryService.changeInventoryStatus(Integer.valueOf(map.get("id")),4)){
            assetService.changeStatus(Integer.valueOf(map.get("assetId")),Integer.valueOf(map.get("status")));
            //        如果二级审核通过，则改变资产的状态为正常
            jsonObject.put("state",true);
        }else{
            jsonObject.put("state",false);
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping("/fuzzyQuery.do")
    public ModelAndView fuzzyQuery(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                   @RequestParam(name = "size", required = true, defaultValue = "10") Integer size,
                                   @RequestParam(name = "senderId", required = false, defaultValue = "") Integer senderId,
                                   @RequestParam(name = "checkStatus", required = false, defaultValue = "")Integer checkStatus,
                                   HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        session=request.getSession();
        session.setAttribute("senderId","");
        session.setAttribute("checkStatus","");
        List<AssetInventory> assetInventoryList = assetInventoryService.findAllSend(page, size,senderId, checkStatus);

        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(assetInventoryList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("assetInventory-page-list");
        return mv;

    }



}
