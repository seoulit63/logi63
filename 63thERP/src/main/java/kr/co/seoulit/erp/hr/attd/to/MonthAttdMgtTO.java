package kr.co.seoulit.erp.hr.attd.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MonthAttdMgtTO extends BaseTO{
	private String empCode, 
				   empName, 
				   applyYearMonth,
				   basicWorkDays,
				   weekdayWorkDays,
				   basicWorkHour,
				   workHour,
				   overWorkHour,
				   nightWorkHour,
				   holidayWorkDays,
				   earlyLeaveDays,
				   holidayWorkHour,
				   lateDays,
				   absentDays,
				   halfHolidays,
				   Holidays,
				   finalizeStatus;
}