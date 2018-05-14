import React, { Component } from "react";
import { createStackNavigator } from "react-navigation";

import {
  Login,
  Grades,
} from "./screens";

export const Root = createStackNavigator({
  Login: {screen: Login},
  Grades: {screen: Grades},
  
});
