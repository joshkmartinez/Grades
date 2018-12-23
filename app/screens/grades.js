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
import { List } from "react-native-elements";
import { Home } from "../components/";
import { _ } from "lodash";
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;
let colors = ["#e53935", "#fb8c00", "#43a047", "#1e88e5", "#8e24aa", "#6d4c41"];

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
  makeRemoteRequest = () => {
    /*
    const { page, seed } = this.state;
    const url = `https://randomuser.me/api/?seed=${seed}&page=${page}&results=20`;
    this.setState({ loading: true });
  
    fetch(url)
      .then(res => res.json())
      .then(res => {
        this.setState({
          data: page === 1 ? res.results : [...this.state.data, ...res.results],
          error: res.error || null,
          loading: false,
          refreshing: false
        });
      })
      .catch(error => {
        this.setState({ error, loading: false });
      });*/
    //do request stuff

    this.setState({ loading: true });

    fetch("https://randomuser.me/api/?seed=33&page=3&results=420")
      .then(res => res.json())
      .then(res => {
        this.setState({
          loading: false
        });
      })
      .catch(error => {
        this.setState({ error, loading: false });
      });
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

  handleRefresh = () => {
    this.setState({ loading: true });
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
