package kr.co.seoulit.erp.hr.attd.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import kr.co.seoulit.erp.hr.attd.sf.AttdServiceFacade;
import kr.co.seoulit.erp.hr.attd.to.DayAttdMgtTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;
import kr.co.seoulit.erp.hr.attd.controller.DayAttdManageController;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/*")
public class DayAttdManageController{
	@Autowired
	private AttdServiceFacade attdServiceFacade;
	private ModelMap modelMap = new ModelMap();

	
	///인봉 이름+날짜로 검색
	   @RequestMapping(value="/attendance/dayAttendanceManage", method=RequestMethod.GET)
	   public ModelMap findDayAttdMgtList(@Param("cday") String cday ,@Param("name") String name){
	   
	            HashMap<String,Object> map=new HashMap<>();
	               
	               System.out.println("이름"+cday);
	               
	               System.out.println("이름"+name);
	                   map.put("name",name);
	                   map.put("applyDay",cday);
	   
	      try {    
	               
	            ArrayList<DayAttdMgtTO> dayAttdMgtList=attdServiceFacade.findDayAttdMgtList(map); 
	   
	            modelMap.put("errorMsg","success");
	            modelMap.put("errorCode", 0);
	            modelMap.put("dayAttdMgtList",dayAttdMgtList);
	         }catch(Exception ioe) {
	                     
	            ioe.printStackTrace();
	            modelMap.clear();
	            modelMap.put("errorMsg", ioe.getMessage());
	                     
	         }
	         return  modelMap;
	   }
	   
	   
	   ///인봉  날짜로 전체 검색
	   @RequestMapping(value="/attendance/dayAttendanceManageAll", method=RequestMethod.GET)
	   public ModelMap findDayAttdMgtListAll(@Param("startDate") String startDate , @Param("endDate") String endDate ){
	   System.out.println("시작"+startDate);
	   System.out.println("시작"+endDate);   
	            HashMap<String,Object> map=new HashMap<>();
	   
	   
	                   map.put("startDate",startDate);
	                   map.put("endDate",endDate);
	                   
	   
	      try {    
	                  
	            ArrayList<DayAttdMgtTO> dayAttdMgtList=attdServiceFacade.findDayAttdMgtListAll(map); 
	   
	            modelMap.put("errorMsg","success");
	            modelMap.put("errorCode", 0);
	            modelMap.put("dayAttdMgtList",dayAttdMgtList);
	         }catch(Exception ioe) {
	                     
	            ioe.printStackTrace();
	            modelMap.clear();
	            modelMap.put("errorMsg", ioe.getMessage());
	                     
	         }
	   
	         return  modelMap;
	   }
	   
	   ///인봉 전체 마감
	   @RequestMapping(value="/attendance/dayDeadlineRegister", method=RequestMethod.PUT)
	   public ModelMap modifyDayAttdList(@RequestBody Map<String,ArrayList<DayAttdMgtTO>> DayAttdMgtToList){
	      
	      System.out.println("제발"+DayAttdMgtToList);
	      HashMap<String,Object> map=new HashMap<>();
	      
	      
	               map.put("DayAttdMgtToList",DayAttdMgtToList);
	            
	   
	      

	      try {
	         ArrayList<DayAttdMgtTO> dayAttdMgtList=attdServiceFacade.dayDeadlineRegister(map); 
	      
	         modelMap.put("errorMsg","success");
	         modelMap.put("errorCode", 0);
	         modelMap.put("dayAttdMgtList",dayAttdMgtList);
	      } catch (Exception ioe) {
	         ioe.printStackTrace();
	         modelMap.clear();
	         modelMap.put("errorMsg", ioe.getMessage());
	         modelMap.put("errorCode",-1);   
	      } 
	      return modelMap;
	   }   
	
	  
	
	   ///인봉  전체 마감취소
	   @RequestMapping(value="/attendance/dayDeadlineCancel", method=RequestMethod.PUT)
	   public ModelMap dayDeadlineCancel(@RequestBody Map<String,ArrayList<DayAttdMgtTO>> DayAttdMgtToList){
	      
	      System.out.println("제발"+DayAttdMgtToList);
	      HashMap<String,Object> map=new HashMap<>();
	      
	      
	               map.put("DayAttdMgtToList",DayAttdMgtToList);
	            
	   
	      

	      try {
	    	  attdServiceFacade.dayDeadlineCancel(map); 
	      
	         modelMap.put("errorMsg","success");
	         modelMap.put("errorCode", 0);
	         //modelMap.put("dayAttdMgtList",dayAttdMgtList);
	      } catch (Exception ioe) {
	         ioe.printStackTrace();
	         modelMap.clear();
	         modelMap.put("errorMsg", ioe.getMessage());
	         modelMap.put("errorCode",-1);   
	      } 
	      return modelMap;
	   }     
	  
	   
	   
//	@RequestMapping(value="/attendance/dayAttendanceManage", method=RequestMethod.GET)
//	public HashMap<Object,Object> findDayAttdMgtList(@Param("applyDay") String applyDay){
//	HashMap<Object,Object> map=new HashMap<>();
//	ArrayList<DayAttdMgtTO> dayAttdMgtList =attdServiceFacade.findDayAttdMgtList(applyDay);
//	map.put("dayAttdMgtList", dayAttdMgtList);
//	return map; 
//	}
//	
	
	@RequestMapping(value="/attendance/dayAttendanceManage", method=RequestMethod.PUT)
	public ModelMap modifyDayAttdList(HttpServletRequest request, HttpServletResponse response){
		
//		String sendData = request.getParameter("sendData");

		try {
			
//			Gson gson = new Gson();
//			ArrayList<DayAttdMgtTO> dayAttdMgtList = gson.fromJson(sendData, new TypeToken<ArrayList<DayAttdMgtTO>>(){}.getType());
//			attdServiceFacade.modifyDayAttdMgtList(dayAttdMgtList);
			modelMap.put("errorMsg","success");
			modelMap.put("errorCode", 0);

		} catch (Exception ioe) {
			ioe.printStackTrace();
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());

		} 
		return modelMap;
	}	

}

