import React from "react";
import {
  View,
  TextInput,
  Alert,
  KeyboardAvoidingView,
  Dimensions,
  AsyncStorage,
  ActivityIndicator,
  BackHandler,
  FlatList,
  SafeAreaView,
  TouchableOpacity
} from "react-native";
import { Constants } from "expo";
import { withNavigation } from "react-navigation";
import PTRView from "react-native-pull-to-refresh";
import SettingsList from "react-native-settings-list";
import { Text, Toast, Root } from "native-base";
import html2json from "html2json";
import ScrollableTabView, {
  DefaultTabBar
} from "react-native-scrollable-tab-view";
import {
  BottomNavigation,
  Surface,
  Button,
  //List,
  Headline,
  Switch,
  Divider,
  Paragraph,
  Dialog,
  Portal,
  Appbar
} from "react-native-paper";
import { parse } from "himalaya";
import { List } from "react-native-elements";
import { Home } from "../components/";
import { _ } from "lodash";
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;
let colors = ["#e53935", "#fb8c00", "#43a047", "#1e88e5", "#8e24aa", "#6d4c41"];
var RCTNetworking = require("RCTNetworking");
function clearCookies() {
  RCTNetworking.clearCookies(cleared => {
    console.log("Cookies cleared, had cookies=" + cleared.toString());
  });
}
export class Grades extends React.Component {
  static navigationOptions = {
    title: "Grades",
    headerLeft: null,
    headerRight: <View style={{ height: 99 }} />,
    header: null,
    gesturesEnabled: false
  };
  constructor() {
    super();
    this.state = {
      index: 0,
      colorIndex: 0,
      isAuthed: false,
      grades: "",
      needToUpdate: false,
      data: [
        {
          name: "English 4H IB",
          grade: 83,
          letterGrade: "A+"
        },
        {
          name: "AP Calculus BC",
          grade: 90,
          letterGrade: "B+"
        },
        {
          name: "AP Spanish 4",
          grade: 96,
          letterGrade: "C+"
        },
        {
          name: "Physics",
          grade: 86,
          letterGrade: "B"
        },
        {
          name: "AP US History",
          grade: 97.3,
          letterGrade: "A"
        },
        {
          name: "AP CS A",
          grade: 101,
          letterGrade: "A+"
        },
        {
          name: "PE",
          grade: 12,
          letterGrade: "F"
        },
        {
          name: "AP World History",
          grade: 93,
          letterGrade: "A"
        }
      ],
      loading: false
    };
  }

  componentWillMount() {
    BackHandler.addEventListener("hardwareBackPress", function() {
      return true;
    });
  }
  async saveAssignments(json) {
    newjson = json[3].children[3].children[1].children[5].children[0].content;
    console.log(newjson);
    await AsyncStorage.setItem("assignments", newjson).catch(console.log);
  }
  makeRemoteRequest = async () => {
    console.log("send Auth func called");
    //console.log("LINK:   " + this.state.schoolLink.replace(/['"]+/g, ""));
    //this.saveLogin(this.state.username, this.state.password);
    this.setState({ loading: true });

    var data = new FormData();
    data.append("checkCookiesEnabled", "true");
    data.append("checkMobileDevice", "false");
    data.append("checkStandaloneMode", "false");
    data.append("checkTabletDevice", "false");
    data.append(
      "portalAccountPassword",
      JSON.stringify(await AsyncStorage.getItem("password")).replace(
        /['"]+/g,
        ""
      )
    );
    data.append(
      "portalAccountUsername",
      JSON.stringify(await AsyncStorage.getItem("username")).replace(
        /['"]+/g,
        ""
      )
    );
    data.append("portalAccountUsernameLabel", "");
    data.append("submit", "");

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    printDstuff = async response => {
      //console.log(response);
      await this.setState({ grades: response });
      //console.log(this.state.grades);
      const html = this.state.grades;
      const json = parse(html);
      console.log("JSON:   " + JSON.stringify(json));
      await this.setState({ grades: json });
      try {
        if (
          json[3].children[8].children[2].children[7].children[1].children[7]
            .children[3].children[3].children[0].content ===
          "The Username and Password entered are incorrect."
        ) {
          this.setState({ isAuthed: false, loading: false });
          this.logOut();
        }
      } catch (error) {
        await this.saveAssignments(this.state.grades);
        this.setState({ isAuthed: true, loading: false });
        this.saveAuthState("yes");
      }
    };
    await xhr.addEventListener("readystatechange", function() {
      if (this.readyState === this.DONE) {
        printDstuff(this.responseText);
      }
    });

    await xhr.open(
      "POST",
      JSON.stringify(await AsyncStorage.getItem("link")).replace(/['"]+/g, "") +
        "/LoginParent.aspx?page=GradebookSummary.aspx"
    );
    clearCookies();
    await xhr.send(data);
  };
  async saveAuthState(authedBool) {
    if (typeof authedBool !== "boolean") {
      //console.log("saving auth state");
      //console.log("the length of " + username + " is " + username.length);
      //console.log("the length of " + password + " is " + password.length);

      await AsyncStorage.setItem("authState", authedBool).catch(console.log);

      console.log("authed state saved");
    } else {
      console.log("you can't store a bool!");
    }
  }
  async getAuthedState() {
    if ((await AsyncStorage.getItem("authState")) !== null) {
      //console.log("getting AuthedState");

      authedvar = JSON.stringify(await AsyncStorage.getItem("authState"));
      this.setState({
        isAuthed: authedvar
      });

      //console.log("authed State saved");
    } else {
      //console.log("No authed state found");
    }
  }
  async getNeedToUpdate() {
    if ((await AsyncStorage.getItem("needToUpdateGrades")) !== null) {
      doI = JSON.stringify(await AsyncStorage.getItem("needToUpdateGrades"));
      if (doI === "yes") {
        this.setState({
          needToUpdate: true
        });
      }
    }
  }
  replaceAll = (str, find, replace) => {
    return str.replace(new RegExp(find, "g"), replace);
  };
  async getSavedGrades() {
    if ((await AsyncStorage.getItem("grades")) !== null) {
      let grades = await AsyncStorage.getItem("grades");
      this.replaceAll(grades, "\n", "");
      this.replaceAll(grades, "\t", "");
      this.replaceAll(grades, "\r", "");
      //console.log("BEFORE:   "+grades)
      this.setState({
        grades: grades
      });
      //console.log("SAVED GRADES:   "+this.state.grades)
    }
  }
  async needToUpdateChange(yesorno) {
    await AsyncStorage.setItem("needToUpdateGrades", yesorno).catch(
      console.log
    );
  }

  handleRefresh = () => {
    this.setState({ loading: true });
    this.getSavedGrades();
    this.makeRemoteRequest();
  };

  logOut = () => {
    this.saveAuthState("no");
    this.props.navigation.navigate("Login");
  };

  renderSeparator = () => {
    return (
      <View>
        {/*<View
        style={{
          height: 1,
          width: "86%",
          backgroundColor: "#CED0CE",
          marginLeft: "14%"
        }}
      />*/}
      </View>
    );
  };

  renderHeader = () => {
    return <View />;
  };
  classSelected = className => {
    //open a page with the grades showing
  };
  renderFooter = () => {
    if (!this.state.loading) return null;

    return (
      <View
        style={{
          paddingVertical: 20,
          borderTopWidth: 1
        }}
      >
        {/*<ActivityIndicator animating size="large" />*/}
      </View>
    );
  };
  render() {
    this.getAuthedState();
    this.getNeedToUpdate();

    if (this.state.needToUpdate) {
      this.handleRefresh();
      this.setState({
        needToUpdate: false
      });
      this.needToUpdateChange("no");
    }
    return (
      <Root
        styles={{ flex: 1, alignItems: "center", justifyContent: "center" }}
      >
        <SafeAreaView
          style={{ flex: 1, alignItems: "center", justifyContent: "center" }}
        >
          <List
            containerStyle={{
              borderTopWidth: 0,
              borderBottomWidth: 0,
              marginTop: Constants.statusBarHeight,
              flex: 1,
              backgroundColor: "transparent"
            }}
          >
            <FlatList
              //style={{ width: width }}
              data={this.state.data}
              renderItem={({ item, index }) => (
                <TouchableOpacity
                  onPress={() => this.props.navigation.navigate("classGrades")}
                >
                  <Surface
                    style={{
                      margin: 3,
                      padding: 9,
                      backgroundColor: colors[index % colors.length],
                      //elevation: 3,
                      justifyContent: "center",
                      width: width - 15,
                      borderRadius: 3,
                      height: height / 10 //divided by the number of classes you have, to a max of like 8, have a space at the bottom
                    }}
                  >
                    <View
                      style={{
                        alignItems: "center",
                        flexDirection: "row",
                        flex: 1
                      }}
                    >
                      <View
                        style={{
                          //backgroundColor: "blue",
                          //height: 20,
                          width: width - width / 2 - 21,
                          //justifyContent: "center",
                          //alignItems: "center",
                          flexDirection: "row"
                        }}
                      >
                        <Text
                          numberOfLines={1}
                          style={{
                            textAlign: "left",
                            alignSelf: "stretch",
                            color: "white",
                            fontSize: responsiveFontSize(3)
                          }}
                        >
                          {item.name}
                        </Text>
                      </View>
                      <View
                        style={{
                          //backgroundColor: "red",
                          //height: 20,
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
                            fontSize: responsiveFontSize(2.6)
                          }}
                        >
                          {item.grade}%
                        </Text>
                        <Text
                          style={{
                            textAlign: "right",
                            //alignSelf: "stretch",
                            color: "white",
                            fontSize: responsiveFontSize(2.6)
                          }}
                        >
                          {item.letterGrade}
                        </Text>
                      </View>
                    </View>
                  </Surface>
                </TouchableOpacity>
              )}
              ItemSeparatorComponent={this.renderSeparator}
              ListHeaderComponent={this.renderHeader}
              ListFooterComponent={this.renderFooter}
              keyExtractor={item => item.name}
              onRefresh={this.handleRefresh}
              refreshing={this.state.loading}
            />
          </List>
          <Appbar
            style={{
              width: width,
              height: 40,
              backgroundColor: "transparent",
              flexDirection: "row",
              justifyContent: "space-between",
              alignItems: "center"
            }}
          >
            <View>
              <TouchableOpacity
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
                        onPress: () => this.logOut()
                      }
                    ],
                    { cancelable: false }
                  )
                }
              >
                <Text style={{ textAlign: "left" }}>Log out</Text>
              </TouchableOpacity>
            </View>
            <TouchableOpacity
              onPress={() => this.props.navigation.navigate("Settings")}
            >
              <Text style={{ textAlign: "left" }}>Settings</Text>
            </TouchableOpacity>
          </Appbar>
        </SafeAreaView>
      </Root>
    );
  }
}

const responsiveFontSize = f => {
  return Math.sqrt(height * height + width * width) * (f / 100);
};
export default withNavigation(Grades);
