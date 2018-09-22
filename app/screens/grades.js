import React from "react";
import {
  View,
  TextInput,
  Alert,
  KeyboardAvoidingView,
  Dimensions,
  AsyncStorage,
  ActivityIndicator,
  BackHandler
} from "react-native";
import PTRView from "react-native-pull-to-refresh";
import { Text, Toast, Root } from "native-base";
import {
  BottomNavigation,
  Surface,
  Button,
  List,
  Headline,
  Switch, Divider
} from "react-native-paper";
import { Home } from "../components/";
import { _ } from "lodash";
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;
import ClassCard from "../components/classCard";
export default class Grades extends React.Component {
  static navigationOptions = {
    title: "Grades",
    headerLeft: null,
    gesturesEnabled: false
  };
  constructor() {
    super();
    this.state = {
      index: 0,
      isAuthed: false,
      routes: [
        { key: "home", title: "Home", icon: "home", color: "#8499B1" },

        {
          key: "settings",
          title: "Settings",
          icon: "settings",
          color: "#8499B1"
        }
      ],

      isSwitchOn: false
    };
  }

  _handleIndexChange = index => this.setState({ index });

  _renderScene = BottomNavigation.SceneMap({
    home: HomeRoute,
    settings: SettingsRoute
  });

  refresh() {
    //get grades and repopulate tabs

    this.setState({ isAuthed: true });
  }
  componentWillMount() {
    BackHandler.addEventListener("hardwareBackPress", function() {
      return true;
    });
  }

  subjectCard(className, grade, letterGrade) {
    return (
      <Surface
        style={{
          padding: 8,
          backgroundColor: "#d50000",
          elevation: 3,
          justifyContent: "center",
          width: width - 21,

          height: height / 8 //divided by the number of classes you have, to a max of like 8, have a space at the bottom
        }}
      >
        <Text
          style={{
            textAlign: "right",
            alignSelf: "stretch",
            color: "white",
            top: 1,
            fontSize: responsiveFontSize(2.3)
          }}
        >
          98%
        </Text>
        <Text
          style={{
            textAlign: "left",
            color: "white",
            fontSize: responsiveFontSize(2.9)
          }}
        >
          AP Calculus
        </Text>
        <Text
          style={{
            textAlign: "right",
            alignSelf: "stretch",
            color: "white",
            fontSize: responsiveFontSize(2.3)
          }}
        >
          A+
        </Text>
      </Surface>
    );
  }

  render() {
    return (
      <Root>
        <BottomNavigation
          styles={{ backgroundcolor: "#8499B1" }}
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
      <Card name="Calculus BC" color="#d50000" letterGrade="A+" grade="99%" />
      <Card name="Calculus BC" color="#ff6d00" letterGrade="A+" grade="99%" />
      <Card name="Calculus BC" color="#00c853" letterGrade="A+" grade="99%" />
      <Card name="Calculus BC" color="#2962ff" letterGrade="A+" grade="99%" />
      <Card name="Calculus BC" color="#aa00ff" letterGrade="A+" grade="99%" />
      <Card name="Calculus BC" color="#c51162" letterGrade="A+" grade="99%" />
    </View>
  </PTRView>
);

const Card = props => (
  <Surface
    style={{
      margin: 4,
      padding: 8,
      backgroundColor: props.color,
      elevation: 3,
      justifyContent: "center",
      width: width - 21,

      height: height / 9 //divided by the number of classes you have, to a max of like 8, have a space at the bottom
    }}
  >
    <Text
      style={{
        textAlign: "right",
        alignSelf: "stretch",
        color: "white",
        top: 1,
        fontSize: responsiveFontSize(2.3)
      }}
    >
      {props.grade}
    </Text>
    <Text
      style={{
        textAlign: "left",
        color: "white",
        fontSize: responsiveFontSize(2.9)
      }}
    >
      {props.name}
    </Text>
    <Text
      style={{
        textAlign: "right",
        alignSelf: "stretch",
        color: "white",
        fontSize: responsiveFontSize(2.3)
      }}
    >
      {props.letterGrade}
    </Text>
  </Surface>
);

const SettingsRoute = () => (
  <View style={{ flex: 1, width: width - 21, alignItems: "center" }}>
    <View style={{ alignItems: "center", justifyContent: "center" }}>
      <Headline>Settings</Headline>
    </View>
    <Button
      icon="person"
      mode="contained"
      onPress={() => console.log("Pressed")}
    >
      Logout
    </Button>
    <Divider />
    {/* add a dark mode toggle
    <Switch
      value={isSwitchOn}
      onValueChange={() => {
        this.setState({ isSwitchOn: !isSwitchOn });
      }}
    />
    
*/}
    <Button icon="help" mode="contained" onPress={() => console.log("Pressed")}>
      Help
    </Button>
    <Divider />
    <Button
      icon="smartphone"
      mode="contained"
      onPress={() => console.log("Pressed")}
    >
      About/Credits
    </Button>
    <Divider />
    {/*make is so the saved username and password are cleared when logout*/}
  </View>
);

const responsiveFontSize = f => {
  return Math.sqrt(height * height + width * width) * (f / 100);
};
