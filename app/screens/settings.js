import React from "react";
import {
  //View,
  //KeyboardAvoidingView,
  Dimensions,
  //AsyncStorage,
  //ActivityIndicator,
  View,
  Alert
} from "react-native";
//import { Button, Text, Toast, Root, Container } from "native-base";
import { _ } from "lodash";
import { withNavigation } from "react-navigation";
import SettingsList from "react-native-settings-list";
import ScrollableTabView, {
  DefaultTabBar
} from "react-native-scrollable-tab-view";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export class Settings extends React.Component {
  static navigationOptions = {
    title: "Settings"
  };

  constructor(props) {
    super(props);
    this.state = {};
  }
  componentDidMount() {
    {
     
    }
  }

  render() {
    return (
      
        <SettingsList backgroundColor="transparent" borderColor="grey" styles={{flex:1, }}>
          <SettingsList.Header
            //headerText="Settings"
            headerStyle={{ color: "black" }}
          />

          <SettingsList.Item
            itemWidth={50}
            title="About / Credits"
            onPress={() => Alert.alert("Go to credits website")}
          />
          <SettingsList.Item
            itemWidth={50}
            title="Help"
            onPress={() => Alert.alert("Direct to help website")}
          />
          <SettingsList.Item
            itemWidth={50}
            title="Log out"
            onPress={() => this.props.navigation.navigate("Login")}
          />
          
        </SettingsList>
      
    );
  }
}

const styles = {
  Spacer: {
    height: 6
  }
};

export default withNavigation(Settings);
