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
import { withNavigation } from "react-navigation";
import PTRView from "react-native-pull-to-refresh";
import SettingsList from "react-native-settings-list";
import { Text, Toast, Root } from "native-base";
import ScrollableTabView, {
  DefaultTabBar
} from "react-native-scrollable-tab-view";
import {
  BottomNavigation,
  Surface,
  Button,
  List,
  Headline,
  Switch,
  Divider,
  Paragraph,
  Dialog,
  Portal
} from "react-native-paper";
import { Home } from "../components/";
import { _ } from "lodash";
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

const HomeRoute = () => (
  <PTRView onRefresh={() => this.refresh}>
    <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
      <Card name="Calculus BC" color="#d50000" letterGrade="A+" grade="99%" />
      <Card name="Calculus BC" color="#ff6d00" letterGrade="A" grade="92%" />
      <Card name="Calculus BC" color="#00c853" letterGrade="A+" grade="99%" />
      <Card name="Calculus BC" color="#2962ff" letterGrade="B" grade="99%" />
      <Card name="Calculus BC" color="#aa00ff" letterGrade="D+" grade="99%" />
      <Card name="Calculus BC" color="#3e2723" letterGrade="C" grade="99%" />
    </View>
  </PTRView>
);

const Card = props => (
  <Surface
    style={{
      margin: 3,
      padding: 8,
      backgroundColor: props.color,
      elevation: 3,
      justifyContent: "center",
      width: width - 16,

      height: height / 10 //divided by the number of classes you have, to a max of like 8, have a space at the bottom
    }}
  >
    <View style={{ alignItems: "center", flexDirection: "row", flex: 1 }}>
      <View
        style={{
          //backgroundColor: "blue",
          height: 20,
          width: width - width / 2 - 21,
          justifyContent: "center",
          alignItems: "center"
        }}
      >
        <Text
          style={{
            textAlign: "left",
            alignSelf: "stretch",
            color: "white",
            fontSize: responsiveFontSize(3.3)
          }}
        >
          {props.name}
        </Text>
      </View>
      <View
        style={{
          //backgroundColor: "red",
          height: 20,
          width: width - width / 2 - 20,
          flexDirection: "column",
          justifyContent: "center"
        }}
      >
        <Text
          style={{
            textAlign: "right",
            //alignSelf: "stretch",
            color: "white",
            fontSize: responsiveFontSize(2.8)
          }}
        >
          {props.grade}
        </Text>
        <Text
          style={{
            textAlign: "right",
            //alignSelf: "stretch",
            color: "white",
            fontSize: responsiveFontSize(2.8)
          }}
        >
          {props.letterGrade}
        </Text>
      </View>
    </View>
  </Surface>
);

const responsiveFontSize = f => {
  return Math.sqrt(height * height + width * width) * (f / 100);
};
export class Grades extends React.Component {
  static navigationOptions = {
    title: "Grades", //no title for now
    headerLeft: null,
    headerRight: <Button icon="settings" />,
    gesturesEnabled: false
  };
  constructor() {
    super();
    this.state = {
      index: 0,
      isAuthed: false
    };
  }

  refresh() {
    //get grades and repopulate tabs
    //refresh

    this.setState({ isAuthed: true });
  }

  componentWillMount() {
    BackHandler.addEventListener("hardwareBackPress", function() {
      return true;
    });
  }

  render() {
    return (
      <Root>
        <ScrollableTabView initialPage={0} tabBarPosition="top">
          <HomeRoute tabLabel="Grades" />

          <View
            style={{ flex: 1, width: width - 9, justifyContent: "center" }}
            tabLabel="Settings"
          >
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
            {/*make is so the saved username and password are cleared when logout*/}
          </View>
        </ScrollableTabView>
      </Root>
    );
  }
}
export default withNavigation(Grades);
