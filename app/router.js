import React, { Component } from 'react'
import { createStackNavigator } from 'react-navigation'

import {
  Login,
  Grades,
  chooseDistrict
} from './screens'

export const Root = createStackNavigator({
  Login: { screen: Login },
  Grades: { screen: Grades },
  chooseDistrict: { screen: chooseDistrict }

})
