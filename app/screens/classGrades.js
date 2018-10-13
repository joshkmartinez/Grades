import React from "react";
import {
  //View,
  //KeyboardAvoidingView,
  Dimensions
  //AsyncStorage,
  //ActivityIndicator
} from "react-native";
//import { Button, Text, Toast, Root, Container } from "native-base";
import { _ } from "lodash";
import { withNavigation } from "react-navigation";
import { default as Student } from "../components/studentLoginForm";
import { default as Parent } from "../components/parentLoginForm";
import ScrollableTabView, {
  DefaultTabBar
} from "react-native-scrollable-tab-view";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export class classGrades extends React.Component {
  static navigationOptions = {
    title: "Settings"
  };

  constructor(props) {
    super(props);
    this.state = {};
  }
  componentDidMount() {
    {
      /*make sure user has internet*/
    }
  }

  render() {
    return (
      <View styles={{ flex: 1 }}>
        
      </View>
    );
  }
}

const styles = {
  
};

export default withNavigation(classGrades);
