package kr.co.seoulit.erp.hr.salary.controller;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import kr.co.seoulit.erp.hr.salary.sf.SalaryServiceFacade;

@RestController
@CrossOrigin("*")
@RequestMapping("/hr/*")
public class BaseExtSalController {
//	@Autowired
//	private SalaryServiceFacade salaryServiceFacade;
	
	
	
	@RequestMapping("/salary/baseExtSalManage.do")
	public void modifyBaseExtSalList(@RequestParam String sendData){
//		 ObjectMapper mapper = new ObjectMapper();
//		 ArrayList<BaseExtSalTO> baseExtSalList = null;
		try {
//		baseExtSalList = mapper.readValue(sendData, new TypeReference<ArrayList<BaseExtSalTO>>(){});
			
		
		} catch (Exception ioe) {
		
		}
//		salaryServiceFacade.modifyBaseExtSalList(baseExtSalList);
}


//	@RequestMapping(value="/salary/baseExtSalManage",method=RequestMethod.GET)


//	public ArrayList<BaseExtSalTO> findBaseExtSalList(){
//		
//			
//			return  salaryServiceFacade.findBaseExtSalList();
//	}
	

}

