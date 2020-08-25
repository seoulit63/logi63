import React from "react";
import { Route, Switch, Redirect, withRouter } from "react-router-dom";
import classnames from "classnames";

// styles
import useStyles from "common/layout/styles";

// components
import HeaderContainer from "common/Header/HeaderContainer";
import Sidebar from "common/Sidebar/Sidebar";
//import LayoutPageRoute from './LayoutPageRoutes';

// pages
import Dashboard from "common/dashboard/Dashboard";
import * as additional from "common/PageRouteComponents/additionalFunctionComponent";
import * as account from "common/PageRouteComponents/accountPageComponents";
import * as hr from "common/PageRouteComponents/hrPageComponents";
import * as logistic from "common/PageRouteComponents/logisticsPageComponents";

// context
import { useLayoutState } from "common/context/LayoutContext";

function Layout(props) {
  var classes = useStyles();

  // global
  var layoutState = useLayoutState();

  return (
    <div className={classes.root}>
      <>
        <HeaderContainer history={props.history} />
        <Sidebar />
        <div
          className={classnames(classes.content, {
            [classes.contentShift]: layoutState.isSidebarOpened,
          })}
        >
          <div className={classes.fakeToolbar} />

          <Switch>
            {/* 메인 홈 : 여기도 이상없이 잘됨 */}
            <Route path="/app/dashboard" component={Dashboard} />
            {/* 각자 업무에 맞게 라우터를 정의 하시오 */}
            {/* 회 계 */}
            {/* 전표입력 */}
            <Route
              exact
              path="/app/acc/account/slipForm"
              component={account.Slip}
            />{" "}
            {/* 일반전표 */}
            <Route
              exact
              path="/app/acc/account/approvalManager"
              component={account.ApprovalManager}
            />{" "}
            {/* 전표승인 */}
            {/* 계정과목 및 계정 */}
            {/* 거래처원장 */}
            <Route
              exact
              path="/app/acc/statement/financialPosition"
              component={account.FinancialStatements}
            />{" "}
            {/* 재무상태표 */}
            <Route
              exact
              path="/app/acc/statement/totalTrialBalance"
              component={account.TotalTrialBalance}
            />{" "}
            {/* 합계잔액시산표 */}
            {/* 전기분손익계산서 */}
            {/* 매입매출장 */}
            {/* 분개장 */}
            <Route
              exact
              path="/app/acc/account/journalForm"
              component={account.JournalForm}
            />
            {/* 인 사 */}
            {/* 인사관리 */}
            <Route
              exact
              path="/app/hr/emp/empDetailedView"
              component={hr.EmpDetailedContainer}
            />{" "}
            {/* 사원상세조회 */}
            <Route
              exact
              path="/app/hr/emp/empRegist"
              component={hr.EmpRegist}
            />
            {/*  사원등록*/}
            {/* 사원메뉴 */}
            <Route
              exact
              path="/app/hr/attendance/dayAttendance"
              component={hr.DayAttendance}
            />{" "}
            {/* 일근태조회/신청 */}
            <Route
              exact
              path="/app/hr/attendance/restAttendance"
              component={hr.RestAttendance}
            />{" "}
            {/* 일근태조회/신청 */}
            {/* 근태관리 */}
            <Route
              exact
              path="/app/hr/attendance/dayAttendanceManage"
              component={hr.DayAttdManage}
            />{" "}
            {/* 일근태관리 */}
            <Route
              exact
              path="/app/hr/attendance/monthAttendanceManage"
              component={hr.MonthAttendanceManage}
            />{" "}
            {/* 월근태관리 */}
            <Route
              exact
              path="/app/hr/attendance/monthAttendanceManage"
              component={hr.MonthAttendanceManage}
            />{" "}
            {/* 급여조회 */}
            {/* 급여관리 */}
            <Route
              exact
              path="/app/hr/salary/closeSalary"
              component={hr.CloseSalaryContainer}
            />{" "}
            {/* 물 류 */}
            {/* 기초정보관리 */}
            {/* 물류정보관리 */}
            {/* 영업관리 */}
            <Route
              exact
              path="/app/logi/sales/estimateInfo"
              component={logistic.Estimate}
            />
            {/* 견적관리 -> 견적조회/수정 */}
            <Route
              exact
              path="/app/logi/sales/estimateRegister"
              component={logistic.EstimateRegister}
            />
             {/* 견적관리 -> 견적추가 */}
            <Route
              exact
              path="/app/logi/sales/contractRegister"

              component={logistic.Contract}
            />{" "}
            {/* 수주관리 }
                  {/* 자재구매관리 */}
            <Route
              path="/app/logi/purchase/orderRegister"
              component={logistic.OrderRegister}
            />
            {/**발주 및 재고처리 */}
            <Route
              path="/app/logi/purchase/stockInfo"
              component={logistic.StockManagement}
            />
            {/* 생산관리 */}
            <Route
              exact
              path="/app/logi/production/mpsRegister"
              component={logistic.MpsRegister}
            />{" "}
            <Route
              exact
              path="/app/logi/production/workInstruction"
              component={logistic.WorkInstruction}
            />{" "}
            {/* MPS */}
            {/* 부가기능 Route 여긴 이상없이 잘됨 */}
            <Route path="/app/typography" component={additional.Typography} />
            <Route path="/app/tables" component={additional.Tables} />
            <Route
              path="/app/notifications"
              component={additional.Notifications}
            />
            <Route
              exact
              path="/app/ui"
              render={() => <Redirect to="/app/ui/icons" />}
            />
            <Route path="/app/ui/maps" component={additional.Maps} />
            <Route path="/app/ui/icons" component={additional.Icons} />
            <Route path="/app/ui/charts" component={additional.Charts} />*
          </Switch>
        </div>
      </>
    </div>
  );
}

export default withRouter(Layout);
