import React, { Component } from "react";
import "ERP/HR/Page/DayAttdManage/DayAttdManage.css";
import { AgGridReact } from "ag-grid-react";
import "ag-grid-community/dist/styles/ag-grid.css";
import "ag-grid-community/dist/styles/ag-theme-balham.css";
import Calendar from "ERP/HR/Page/DayAttdManage/Calendar";

//npm install --save ag-grid-community ag-grid-react  설치해야 ag그리드 가능
class Grid extends Component {
  // state = {
  //   name: this.state.rowData
  //   };

  constructor(props) {
    super(props);

    // 전표 그리드에 뿌릴 data의 state.

    this.state = {
      columnDefs: [
        //{ headerName: '', field: 'check', width: 50, checkboxSelection: true },  // checkboxSelection : 체크박스 추가함
        { headerName: "사원코드", field: "empCode", width: 100 },
        { headerName: "사원명", field: "empName", width: 100 },
        { headerName: "적용일", field: "applyDays", width: 170 },
        { headerName: "일근태구분코드", field: "dayAttdCode", width: 130 },
        { headerName: "일근태구분명", field: "dayAttdName", width: 120 },
        {
          headerName: "출근시각",
          field: "attendTime",
          width: 100,
          editable: true,
        },
        { headerName: "퇴근시각", field: "quitTime", width: 100 },
        { headerName: "지각여부", field: "lateWhether", width: 100 },
        { headerName: "총 외출시간", field: "leaveHour", width: 110 },
        { headerName: "공외출시간", field: "publicleaveHour", width: 110 },
        { headerName: "사외출시간", field: "privateleaveHour", width: 110 },
        { headerName: "정상근무시간", field: "workHour", width: 120 },
        { headerName: "연장근무시간", field: "overWorkHour", width: 120 },
        { headerName: "심야근무시간", field: "nightWorkHour", width: 120 },
        { headerName: "마감여부", field: "finalizeStatus", width: 110 },
      ],
      rowData: [],
    };
  }

  render() {
    return (
      <div className="Grid">
        <div
          className="ag-theme-alpine"
          style={{
            height: "400px",
            width: "1680px",
          }}
        >
          <AgGridReact
            columnDefs={this.state.columnDefs}
            rowData={this.props.data}
          ></AgGridReact>
        </div>
      </div>
    );
  }
}
export default Grid;
