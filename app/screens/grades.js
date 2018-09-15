import React from "react";
import {
  View,
  TextInput,
  Alert,
  KeyboardAvoidingView,
  Dimensions,
  AsyncStorage,
  ActivityIndicator
} from "react-native";
import PTRView from "react-native-pull-to-refresh";
import { Button, Text, Toast, Root } from "native-base";
import { BottomNavigation } from "react-native-paper";
import { Home } from "../components/";
import { _ } from "lodash";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export default class Grades extends React.Component {
  static navigationOptions = {
    title: "Grades"
  };
  constructor() {
    super();
    this.state = {
      index: 0,
      isAuthed: false,
      routes: [
        { key: "home", title: "Home", icon: "home" },
        { key: "profile", title: "Profile", icon: "person" },
        { key: "settings", title: "Settings", icon: "settings" }
      ]
    };
    
  }

  _handleIndexChange = index => this.setState({ index });

  _renderScene = BottomNavigation.SceneMap({
    home: HomeRoute,
    settings: SettingsRoute,
    profile: ProfileRoute
  });

  refresh() {
    //get grades and repopulate tabs
    setTimeout(() => {}, 2000);
    this.setState({ isAuthed: true });
  }

  render() {
    return (
      <Root>
        <BottomNavigation
          navigationState={this.state}
          onIndexChange={this._handleIndexChange}
          renderScene={this._renderScene}
        />
      </Root>
    );
  }
}
const HomeRoute = () => (
  <PTRView onRefresh={() => this.refresh}>
    <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
      <Text>Logged in:</Text>
    </View>
  </PTRView>
);

const ProfileRoute = () => <Text>Profile</Text>;

const SettingsRoute = () => <Text>Settings</Text>;
