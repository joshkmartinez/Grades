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
      /*make sure user has internet*/
    }
  }

  render() {
    return (
      <View styles={{ flex: 1 }}>
        <SettingsList backgroundColor="transparent">
          <SettingsList.Header
            headerText="Settings"
            headerStyle={{ color: "black" }}
          />

          <SettingsList.Item
            itemWidth={50}
            title="About/Credits"
            onPress={() => Alert.alert("Go to credits website")}
          />
          <SettingsList.Item
            itemWidth={50}
            title="Help"
            onPress={() => Alert.alert("Direct to help website")}
          />
          <SettingsList.Item
            itemWidth={50}
            title="Logout"
            onPress={() =>
              Alert.alert(
                "Log out",
                "Do you want to log out?",
                [
                  {
                    text: "No",
                    onPress: () => console.log("Cancel Pressed")
                  },
                  {
                    text: "Yes",
                    onPress: () => this.props.navigation.navigate("Login")
                  }
                ],
                { cancelable: false }
              )
            }
          />
        </SettingsList>
      </View>
    );
  }
}

const styles = {
  Spacer: {
    height: 6
  }
};

export default withNavigation(Settings);
