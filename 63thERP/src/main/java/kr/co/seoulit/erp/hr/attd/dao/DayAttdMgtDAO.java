package kr.co.seoulit.erp.hr.attd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.attd.to.DayAttdMgtTO;


@Mapper
public interface DayAttdMgtDAO {
	public ArrayList<DayAttdMgtTO> batchDayAttdMgtProcess(HashMap<String, Object> param);
	public void updateDayAttdMgtList(HashMap<String, Object> map1);//�κ�
	   public ArrayList<DayAttdMgtTO> selectDayAttdMgtProcessAll(HashMap<String, Object> map);//�κ�
	   public void updateAttd(DayAttdMgtTO dayAttdMgt);
	   public ArrayList<DayAttdMgtTO> selectDayAttdMgt1(HashMap<String, Object> map);//�κ�
	public ArrayList<DayAttdMgtTO> batchDayAttdMgtProcesses(HashMap<String, Object> map); //�κ�
	public void CanCelDayAttdMgtList(HashMap<String, Object> map1);
}
