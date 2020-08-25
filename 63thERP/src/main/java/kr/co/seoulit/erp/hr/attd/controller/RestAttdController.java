package kr.co.seoulit.erp.hr.attd.controller;


import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import kr.co.seoulit.erp.hr.attd.sf.AttdServiceFacade;

import kr.co.seoulit.erp.hr.attd.to.RestAttdTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/*")
public class RestAttdController {
	
	@Autowired
	private AttdServiceFacade attdServiceFacade;
	private ModelAndView modelAndView = null;
	private ModelMap modelMap = new ModelMap();

	/*
	 * public ModelAndView findRejectRestAttdList(HttpServletRequest request,
	 * HttpServletResponse response){ HashMap<String, Object> model = new
	 * HashMap<String, Object>(); String empCode = request.getParameter("empCode");
	 * String applyYear = request.getParameter("applyYear");
	 * response.setContentType("application/json; charset=UTF-8"); try {
	 * out=response.getWriter(); ArrayList<RestAttdTO> rejectRestAttdList =
	 * attdServiceFacade.findRejectRestAttdList(empCode, applyYear);
	 * model.put("errorMsg","success"); model.put("errorCode", 0);
	 * model.put("rejectRestAttdList", rejectRestAttdList);
	 * 
	 * JSONObject jsonObject = JSONObject.fromObject(model);
	 * out.println(jsonObject); } catch (IOException ioe) {
	 * logger.fatal(ioe.getMessage()); String viewname = "redirect:welcome.html";
	 * model.clear(); model.put("errorMsg", ioe.getMessage()); modelAndView = new
	 * ModelAndView(viewname, model); } catch (DataAccessException dae){
	 * logger.fatal(dae.getMessage()); model.clear(); model.put("errorCode", -1);
	 * model.put("errorMsg", dae.getMessage()); JSONObject jsonObject =
	 * JSONObject.fromObject(model); out.println(jsonObject); } finally {
	 * out.close(); } return modelAndView; }
	 */

	public ModelAndView findRestAttdListByToday(HttpServletRequest request, HttpServletResponse response) {
		String empCode = request.getParameter("empCode");
		String toDay = request.getParameter("toDay");
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			ArrayList<RestAttdTO> restAttdList = attdServiceFacade.findRestAttdListByToday(empCode, toDay);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
			modelMap.put("restAttdList", restAttdList);

		} catch ( Exception ioe) {
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}
		modelAndView = new ModelAndView("jsonView", modelMap);
		return modelAndView;
	}

	/*
	 * public ModelAndView findUseAnnualLeaveList(HttpServletRequest request,
	 * HttpServletResponse response){ HashMap<String, Object> model = new
	 * HashMap<String, Object>(); String empCode = request.getParameter("empCode");
	 * String startDate = request.getParameter("startDate"); String endDate =
	 * request.getParameter("endDate");
	 * response.setContentType("application/json; charset=UTF-8");
	 * 
	 * try { out=response.getWriter();
	 * 
	 * ArrayList<RestAttdTO> useAnnualLeaveList =
	 * attdServiceFacade.findUseAnnualLeaveList(empCode,startDate, endDate);
	 * model.put("errorMsg","success"); model.put("errorCode", 0);
	 * model.put("useAnnualLeaveList", useAnnualLeaveList);
	 * 
	 * JSONObject jsonObject = JSONObject.fromObject(model);
	 * out.println(jsonObject);
	 * 
	 * } catch (IOException ioe) { logger.fatal(ioe.getMessage()); String viewname =
	 * "redirect:welcome.html"; model.clear(); model.put("errorMsg",
	 * ioe.getMessage()); modelAndView = new ModelAndView(viewname, model); } catch
	 * (DataAccessException dae){ logger.fatal(dae.getMessage()); model.clear();
	 * model.put("errorCode", -1); model.put("errorMsg", dae.getMessage());
	 * JSONObject jsonObject = JSONObject.fromObject(model);
	 * out.println(jsonObject); } finally { out.close(); } return modelAndView; }
	 */
	
	@RequestMapping("/attendance/registRestAttd")
	public ModelMap registRestAttd(HttpServletRequest request, HttpServletResponse response) {
		
//		String sendData = request.getParameter("sendData");
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
//			Gson gson = new Gson();
//			RestAttdTO restAttd = gson.fromJson(sendData, RestAttdTO.class);
//			attdServiceFacade.registRestAttd(restAttd);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
			} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}
		return modelMap;
	}
	@RequestMapping("/attendance/findRestAttdList")
	public ModelMap findRestAttdList(HttpServletRequest request, HttpServletResponse response) {
	
		String empCode = request.getParameter("empCode");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String code = request.getParameter("code");
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			ArrayList<RestAttdTO> restAttdList = attdServiceFacade.findRestAttdList(empCode, startDate, endDate, code);
			modelMap.put("restAttdList", restAttdList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
			}
		return modelMap;
	}
	@RequestMapping("/attendance/removeRestAttdList")
	public ModelMap removeRestAttdList(HttpServletRequest request, HttpServletResponse response) {
		
//		String sendData = request.getParameter("sendData");
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			// 媛��명��怨� �깅�μ��� gson�쇰� 蹂�寃�
//			Gson gson = new Gson();
//			ArrayList<RestAttdTO> restAttdList = gson.fromJson(sendData, new TypeToken<ArrayList<RestAttdTO>>() {
//			}.getType());
//			attdServiceFacade.removeRestAttdList(restAttdList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		} 
		return modelMap;
	}

	/*
	 * public ModelAndView removeRejectRestAttdList(HttpServletRequest request,
	 * HttpServletResponse response){ HashMap<String, Object> model = new
	 * HashMap<String, Object>(); String sendData =
	 * request.getParameter("sendData");
	 * response.setContentType("application/json; charset=UTF-8"); try {
	 * out=response.getWriter(); // 媛��명��怨� �깅�μ��� gson�쇰� 蹂�寃� Gson gson = new Gson();
	 * ArrayList<RestAttdTO> rejectRestAttdList = gson.fromJson(sendData, new
	 * TypeToken<ArrayList<RestAttdTO>>(){}.getType());
	 * attdServiceFacade.removeRejectRestAttdList(rejectRestAttdList);
	 * model.put("errorMsg","success"); model.put("errorCode", 0);
	 * 
	 * JSONObject jsonObject = JSONObject.fromObject(model);
	 * out.println(jsonObject);
	 * 
	 * } catch (IOException ioe) { logger.fatal(ioe.getMessage()); String viewname =
	 * "redirect:welcome.html"; model.clear(); model.put("errorMsg",
	 * ioe.getMessage()); modelAndView = new ModelAndView(viewname, model); } catch
	 * (DataAccessException dae){ logger.fatal(dae.getMessage()); model.clear();
	 * model.put("errorCode", -1); model.put("errorMsg", dae.getMessage());
	 * JSONObject jsonObject = JSONObject.fromObject(model);
	 * out.println(jsonObject); } finally { out.close(); } return modelAndView; }
	 */
	
	
	
	   
	   ///인봉  근태외유형가져오기
	   @RequestMapping(value="/attendance/searchRestAttendanceType", method=RequestMethod.GET)
	   public ModelMap searchRestAttendanceType(){
	      
	    
	   
	      try {
	    	  ArrayList<HrDetailCodeTO> typeList=attdServiceFacade.searchRestAttendanceType(); 
	     
	         modelMap.put("errorMsg","success");
	         modelMap.put("errorCode", 0);
	         modelMap.put("typeList",typeList);
	      } catch (Exception ioe) {
	         ioe.printStackTrace();
	         modelMap.clear();
	         modelMap.put("errorMsg", ioe.getMessage());
	         modelMap.put("errorCode",-1);   
	      } 
	      return modelMap;
	   }   
}
