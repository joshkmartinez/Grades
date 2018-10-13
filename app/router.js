import React, { Component } from "react";
import { createStackNavigator } from "react-navigation";

import { Login, Grades, chooseDistrict, Settings, classGrades } from "./screens";

export const Root = createStackNavigator({
  Login: { screen: Login },
  Grades: { screen: Grades },
  chooseDistrict: { screen: chooseDistrict },
  Settings: { screen: Settings },
  classGrades: { screen: classGrades }
});
