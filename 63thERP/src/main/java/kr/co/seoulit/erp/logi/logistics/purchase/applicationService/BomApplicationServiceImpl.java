package kr.co.seoulit.erp.logi.logistics.purchase.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logi.logistics.purchase.dao.BomDAO;
import kr.co.seoulit.erp.logi.logistics.purchase.to.BomDeployTO;
import kr.co.seoulit.erp.logi.logistics.purchase.to.BomInfoTO;
import kr.co.seoulit.erp.logi.logistics.purchase.to.BomTO;

@Component
public class BomApplicationServiceImpl implements BomApplicationService {

	@Autowired
	private BomDAO bomDAO;

	public ArrayList<BomDeployTO> getBomDeployList(String deployCondition, String itemCode, String itemClassificationCondition) {

		HashMap<String,String> param = new HashMap<>(); 
		param.put("deployCondition",deployCondition);
		param.put("itemCode",itemCode);
		param.put("itemClassificationCondition",itemClassificationCondition);
		System.out.println("!@###!@#@!#@!#@!#@!#!@#!@"+deployCondition+":"+itemCode+":"+itemClassificationCondition);
		return bomDAO.selectBomDeployList(param);
	}
	
	public ArrayList<BomInfoTO> getBomInfoList(String parentItemCode) {

		return bomDAO.selectBomInfoList(parentItemCode);
	}

	public ArrayList<BomInfoTO> getAllItemWithBomRegisterAvailable() {

		return bomDAO.selectAllItemWithBomRegisterAvailable();

	}

	public HashMap<String, Object> batchBomListProcess(ArrayList<BomTO> batchBomList) {

		HashMap<String, Object> resultMap = new HashMap<>();

			int insertCount = 0;
			int updateCount = 0;
			int deleteCount = 0;

			for (BomTO TO : batchBomList) {

				String status = TO.getStatus();

				switch (status) {

				case "INSERT":

					bomDAO.insertBom(TO);

					insertCount++;

					break;

				case "UPDATE":

					bomDAO.updateBom(TO);

					updateCount++;

					break;

				case "DELETE":

					bomDAO.deleteBom(TO);

					deleteCount++;

					break;

				}

			}

			resultMap.put("INSERT", insertCount);
			resultMap.put("UPDATE", updateCount);
			resultMap.put("DELETE", deleteCount);

		return resultMap;
	}

}
