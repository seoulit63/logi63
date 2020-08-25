import React, { useState, useMemo, memo } from "react";
import axios from "axios";
import useMonth from "../MonthAttendance/useMonth"; //이거 나중에 util로 집어넣자
import { AgGridReact } from "ag-grid-react";
import Select from "react-select";
import { Button, FormControl } from "@material-ui/core";
import MenuItem from "@material-ui/core/MenuItem";
import InputIcon from "@material-ui/icons/Input";
import SearchIcon from "@material-ui/icons/Search";

const CloseSalary = ({
  handleChange,
  callCloseSalary,
  onRowSelected,
  salaryList,
  findCloseSalary,
  setEvent,
  empCodes,
}) => {
  const state = {
    columnDefs: [
      {
        headerName: "사원코드",
        field: "empCode",
        sortable: true,
        headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true,
      },
      { headerName: "적용월", field: "applyYearMonth", hide: true },
      { headerName: "기본급", field: "salary" },
      { headerName: "추가수당", field: "totalExtSal" },
      { headerName: "총급여", field: "totalPayment" },
      { headerName: "공제금액", field: "totalDeduction" },
      { headerName: "실지급금", field: "realSalary" },
      { headerName: "심야근무시간", field: "cost" },
      { headerName: "휴일근무일수", field: "unusedDaySalary" },
      { headerName: "마감상태", field: "finalizeStatus" },
      { headerName: "부서코드", field: "deptCode", hide: true },
    ],
    rowSelection: "multiple",
    rowData: salaryList,
  };

  const set1 = useMonth();

  const selectedDeptd = [
    {
      value: "DPT-01",
      label: "총무부",
    },
    {
      value: "DPT-02",
      label: "영업부",
    },
    {
      value: "DPT-03",
      label: "생산부",
    },
  ];

  return (
    <div>
      <FormControl style={{ maxWidth: "600px" }}> </FormControl>
      <FormControl style={{ minWidth: "250px" }}>
        <Select
          onChange={handleChange}
          name="dept"
          // onInputChange={handleInputChange}
          placeholder="부서를 선택해주세요"
          options={selectedDeptd}
          style={{
            width: "500px",
          }}
        ></Select>
      </FormControl>

      <FormControl style={{ Width: "600px" }}> </FormControl>
      <FormControl style={{ minWidth: "250px" }}>
        <Select
          onChange={handleChange}
          name="date"
          // onInputChange={handleInputChange}
          placeholder="날짜를 선택해주세요"
          options={set1.selectedmonth}
        />
      </FormControl>
      <Button
        variant="contained"
        color="primary"
        size="large"
        startIcon={<SearchIcon />}
        onClick={findCloseSalary}
      >
        조회
      </Button>
      <Button
        variant="contained"
        color="primary"
        size="large"
        startIcon={<InputIcon />}
        onClick={callCloseSalary}
      >
        마감
      </Button>
      <div
        className="ag-theme-balham"
        style={{
          height: "600px",
          width: "1200px",
        }}
      >
        <AgGridReact
          suppressRowClickSelection={true}
          columnDefs={state.columnDefs}
          rowData={state.rowData}
          onRowSelected={onRowSelected}
          rowSelection={state.rowSelection}
          onGridReady={event => {
            event.api.sizeColumnsToFit();
            setEvent(event.api);
          }}
        ></AgGridReact>
      </div>
    </div>
  );
};
export default CloseSalary;
