import React from "react";
import {
  //View,
  //KeyboardAvoidingView,
  Dimensions,
  //AsyncStorage,
  //ActivityIndicator
} from "react-native";
//import { Button, Text, Toast, Root, Container } from "native-base";
import { _ } from "lodash";
import { default as Student } from "../components/studentLoginForm";
import { default as Parent } from "../components/parentLoginForm";
import ScrollableTabView, {
  DefaultTabBar
} from "react-native-scrollable-tab-view";

let width = Dimensions.get("window").width
let height = Dimensions.get("window").height

export default class Login extends React.Component {
  static navigationOptions = {
    title: "Login to Aeries"
  };

  constructor(props) {
    super(props);
    this.state = {
      
    };
  }
  componentDidMount() {
    {
      /*make sure user has internet*/
    }
  }

  render() {
    return (
      <ScrollableTabView initialPage={0}>
        <Student tabLabel="Student Login" />
        <Parent tabLabel="Parent Login" />
      </ScrollableTabView>
    );
  }
}

const styles = {
  Spacer: {
    height: 6
  }
};
