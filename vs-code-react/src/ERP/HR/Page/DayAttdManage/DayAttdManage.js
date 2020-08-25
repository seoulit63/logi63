import React, { Component } from "react";

import Grid from "ERP/HR/Page/DayAttdManage/Grid";
import Calendar from "ERP/HR/Page/DayAttdManage/Calendar";

import Head from "ERP/HR/Page/DayAttdManage/Head";
import LiveClock from "ERP/HR/Page/DayAttdManage/LiveClock";

class DayAttdManage extends Component {
  constructor(props) {
    super(props);

    this.state = {
      data: null,
    };
  }

  handlerCalendarChange = data => {
    console.log("데이타", data);
    this.setState({ data: data });
  };

  render() {
    return (
      <div>
        <LiveClock />
        <Head />

        <Calendar onChange={this.handlerCalendarChange} />

        <Grid data={this.state.data} />
      </div>
    );
  }
}
export default DayAttdManage;