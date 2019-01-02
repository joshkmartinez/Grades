import React from "react";
import {
  View,
  KeyboardAvoidingView,
  Dimensions,
  AsyncStorage,
  ActivityIndicator,
  Keyboard
} from "react-native";
import { Text, Toast, Root, Spinner } from "native-base";
import { _ } from "lodash";
import { withNavigation, Header } from "react-navigation";
import { ScrollView } from "react-native-gesture-handler";
import { Surface, TextInput, Button } from "react-native-paper";
//import "url-search-params-polyfill";

import axios from "axios";
//import CookieManager from 'react-native-cookies';
import { parse } from "himalaya";
const queryString = require("query-string");
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;
axios.interceptors.request.use(request => {
  console.log("Sending Request:   ", request);
  return request;
});
//axios.defaults.withCredentials = true;
//axios.defaults.jar = true;
axios.interceptors.response.use(response => {
  console.log("Response from request:   ", response);
  return response;
});
var RCTNetworking = require("RCTNetworking");
function clearCookies() {
  RCTNetworking.clearCookies(cleared => {
    console.log("Cookies cleared, had cookies = " + cleared.toString());
  });
}
class StudentLoginForm extends React.Component {
  constructor(props) {
    super(props);
    //this.saveGrades = this.saveGrades.bind(this);

    this.state = {
      isAuthed: false,
      username: "",
      authError: false,
      password: "",
      districtText: "",
      names: [],
      grades: "",
      schoolLink: "",
      loading: false,
      loginDisabled: true,
      importedSavedLogin: false
    };
  }
  componentDidMount() {
    // make sure user has internet
    this.refreshSchoolandName();
  }

  async checkIfLinkExists() {
    if ((await AsyncStorage.getItem("link")) !== null) {
      //console.log("LOGIN FILE: async LINK data exists");
      const link = JSON.stringify(await AsyncStorage.getItem("link"));
      //console.log(link)

      this.setState({ schoolLink: link });

      //console.log("UPDATED LINK: " + this.state.schoolLink)
    } else {
      //console.log("School Link data does NOT exist");
      this.setState({ districtText: "Select a school before proceeding" });
    }
  }
  async checkIfSchoolNameExists() {
    if ((await AsyncStorage.getItem("name")) !== null) {
      //console.log("LOGIN FILE: async NAME data exists");
      const name = JSON.stringify(await AsyncStorage.getItem("name"));
      //console.log(name)
      if (name !== this.state.districtText) {
        Toast.show({
          text: "School Chosen",
          buttonText: "Ok",
          duration: 1234, //in miliseconds
          position: "top",
          type: "success"
        });
      }
      this.setState({ districtText: name });
      //console.log("UPDATED school name STATE: " + this.state.schoolLink)
    } else {
      console.log("School name is found");
    }
  }

  async getSavedLogin() {
    if (
      (await AsyncStorage.getItem("username")) !== null &&
      (await AsyncStorage.getItem("password")) !== null &&
      this.state.importedSavedLogin === false
    ) {
      console.log("retrieving saved login info");
      savedUsername = JSON.stringify(await AsyncStorage.getItem("username"));
      savedPassword = JSON.stringify(await AsyncStorage.getItem("password"));
      this.setState({
        username: savedUsername.replace(/['"]+/g, ""),
        password: savedPassword.replace(/['"]+/g, "")
      });
      this.setState({ importedSavedLogin: true });
      console.log("saved username and password set");
    }
  }

  async saveLogin(username, password) {
    console.log("saving username and password");
    //console.log("the length of " + username + " is " + username.length);
    //console.log("the length of " + password + " is " + password.length);

    await AsyncStorage.setItem("username", username).catch(console.log);
    await AsyncStorage.setItem("password", password).catch(console.log);
    console.log("Login info saved for: " + username);
  }
  async saveAuthState(authedBool) {
    console.log("saving auth state");
    //console.log("the length of " + username + " is " + username.length);
    //console.log("the length of " + password + " is " + password.length);
    //authBool is "yes" or "no"
    //** */you cannot async store a boolean**
    await AsyncStorage.setItem("authState", authedBool).catch(console.log);
    console.log("authed state saved");
  }

  saveGrades = async html => {
    //json = html2json(html.request._response);

    await AsyncStorage.setItem("grades", html).catch(console.log);
  };
  async getGrades() {
    if ((await AsyncStorage.getItem("grades")) !== null) {
      this.setState({
        grades: await AsyncStorage.getItem("grades")
      });
    }
  }
  needToUpdateGrades = async yn => {
    await AsyncStorage.setItem("needToUpdateGrades", yn).catch(console.log);
  };
  async saveAssignments(json) {
    newjson = json[3].children[3].children[1].children[5].children[0].content;
    console.log(newjson);
    await AsyncStorage.setItem("assignments", newjson).catch(console.log);
  }

  async saveClasses(json) {
    //while ans != null
    i = 5;
    name = "";
    prevName = "test";
    names = [];
    while (name != undefined) {
      try {
        name =
          json[3].children[3].children[1].children[19].children[1].children[1]
            .children[5].children[0].children[11].children[1].children[1]
            .children[1].children[1].children[14].children[5].children[1]
            .children[1].children[1].children[0].children[0].children[1]
            .children[i].children[5].children[0].children[0].content;
      } catch (e) {
        console.log("reached class end");
        break;
      }
      i += 2;

      names.push(name);
    }
    JSON.stringify(names);
    console.log("Class names:   " + names);
    this.setState({ names: JSON.stringify(names) });
    await AsyncStorage.setItem("classes", JSON.stringify(names)).catch(
      console.log
    );
  }
  async savePercents(json) {
    //while ans != null
    i = 5;
    name = "";
    prevName = "test";
    names = [];
    while (name != undefined) {
      try {
        name =
          json[3].children[3].children[1].children[19].children[1].children[1]
            .children[5].children[0].children[11].children[1].children[1]
            .children[1].children[1].children[14].children[5].children[1]
            .children[1].children[1].children[0].children[0].children[1]
            .children[i].children[13].children[0].children[0].content;
      } catch (e) {
        console.log("reached class end");
        break;
      }
      i += 2;

      names.push(name);
    }
    JSON.stringify(names);
    console.log("Class percents:   " + names);
    this.setState({ names: JSON.stringify(names) });
    await AsyncStorage.setItem("percents", JSON.stringify(names)).catch(
      console.log
    );
  }

  async saveLetterGrades(json) {
    //while ans != null
    i = 5;
    name = "";
    prevName = "test";
    names = [];
    while (name != undefined) {
      try {
        name =
          json[3].children[3].children[1].children[19].children[1].children[1]
            .children[5].children[0].children[11].children[1].children[1]
            .children[1].children[1].children[14].children[5].children[1]
            .children[1].children[1].children[0].children[0].children[1]
            .children[i].children[17].children[0].children[0].content;
      } catch (e) {
        console.log("reached class end");
        break;
      }
      i += 2;

      names.push(name);
    }
    JSON.stringify(names);
    console.log("Class letter grades:   " + names);
    this.setState({ names: JSON.stringify(names) });
    await AsyncStorage.setItem("letter", JSON.stringify(names)).catch(
      console.log
    );
  }

  refreshSchoolandName = _.debounce(() => {
    this.checkIfLinkExists();
    this.checkIfSchoolNameExists();
  }, 333);
  spacer(space) {
    return <View styles={{ height: space }} />;
  }

  sendAuth = async () => {
    console.log("send Auth func called");
    Keyboard.dismiss();
    //console.log("LINK:   " + this.state.schoolLink.replace(/['"]+/g, ""));
    this.saveLogin(this.state.username, this.state.password);
    this.setState({ loading: true });
    var data = new FormData();
    data.append("checkCookiesEnabled", "true");
    data.append("checkMobileDevice", "false");
    data.append("checkStandaloneMode", "false");
    data.append("checkTabletDevice", "false");
    data.append(
      "portalAccountPassword",
      this.state.password.replace(/['"]+/g, "")
    );
    data.append(
      "portalAccountUsername",
      this.state.username.replace(/['"]+/g, "")
    );
    data.append("portalAccountUsernameLabel", "");
    data.append("submit", "");

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    printDstuff = async response => {
      //console.log(response);
      await this.setState({ grades: response });
      console.log(this.state.grades);
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
          Toast.show({
            text: "The Username or Password entered is incorrect.",
            buttonText: "OK",
            duration: 4321, //in miliseconds
            position: "top",
            type: "danger"
          });
        }
      } catch (error) {
        await this.saveAssignments(this.state.grades);
        await this.saveClasses(this.state.grades);
        await this.savePercents(this.state.grades);
        await this.saveLetterGrades(this.state.grades);
        this.setState({ isAuthed: true, loading: false });
        this.saveAuthState("yes");

        this.props.navigation.navigate("Grades");
      }
      if (true) {
      }
    };
    await xhr.addEventListener("readystatechange", function() {
      if (this.readyState === this.DONE) {
        printDstuff(this.responseText);
      }
    });

    await xhr.open(
      "POST",
      this.state.schoolLink.replace(/['"]+/g, "") +
        "/LoginParent.aspx?page=GradebookSummary.aspx"
    );
    clearCookies();
    await xhr.send(data);
  };

  canLogin = () => {
    //if all forms filled out then make button enabled
    //buttonDisabled
  };

  render() {
    this.refreshSchoolandName();
    this.getSavedLogin();
    this.canLogin();
    return (
      <Root>
        <View style={styles.wrapper}>
          <KeyboardAvoidingView
            behavior="padding"
            keyboardVerticalOffset={0}
            style={styles.loginContainer}
          >
            <Surface
              style={{
                padding: 9,
                backgroundColor: "whitesmoke",
                alignItems: "center",
                justifyContent: "center",
                elevation: 3,
                borderRadius: 6
              }}
            >
              <View
                style={{
                  flexDirection: "column",
                  justifyContent: "center",
                  alignItems: "center"
                }}
              >
                <View
                  style={{
                    flexDirection: "column",
                    justifyContent: "center",
                    alignItems: "center",
                    padding: 3
                  }}
                >
                  <Button
                    icon="search"
                    mode="contained"
                    color="whitesmoke"
                    style={{ width: width - 69 }}
                    onPress={() =>
                      this.props.navigation.navigate("chooseDistrict")
                    }
                  >
                    <Text> Choose School / District </Text>
                  </Button>
                </View>
                <Text
                  adjustsFontSizeToFit
                  numberOfLines={1}
                  style={styles.districtText}
                >
                  {this.state.districtText.replace(/^"(.+(?="$))"$/, "$1")}
                  {/*This is some regex that removes quotes from the string so it can display nicely*/}
                </Text>
              </View>

              <TextInput
                mode="outlined"
                placeholder="school email"
                keyboardType="email-address"
                autoCapitalize="none"
                autoCorrect={false}
                placeholderTextColor="white"
                style={styles.input}
                onChangeText={username => this.setState({ username })}
                value={this.state.username}
              />

              <TextInput
                mode="outlined"
                placeholder="password"
                secureTextEntry
                autoCorrect={false}
                autoCapitalize="none"
                placeholderTextColor="white"
                style={styles.input}
                onChangeText={password => this.setState({ password })}
                value={this.state.password}
              />

              <View
                style={{
                  flexDirection: "column",
                  justifyContent: "center",
                  alignItems: "center"
                }}
              >
                {/*the component below shows ActivityIndicator if this.state.loading: true; else will show 
              login button*/}
                <Button
                  icon="check"
                  //disabled={this.state.buttonDisabled}
                  mode="contained"
                  color="whitesmoke"
                  onPress={() => this.sendAuth()}
                >
                  <Text> Login </Text>
                </Button>
                {this.state.loading ? <Spinner color="black" /> : <View />}
              </View>
            </Surface>
          </KeyboardAvoidingView>
        </View>
      </Root>
    );
  }
}

const styles = {
  loginContainer: {
    top: "29%"
  },

  districtText: { top: 1 },

  input: {
    margin: 12,
    width: width - 69
  },

  wrapper: {
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    justifyContent: "center",
    alignItems: "center"
  },

  loginButton: {
    borderRadius: 3,
    marginTop: 9,
    marginBottom: 21
  },
  error: {
    color: "red",
    textAlign: "center"
  }
};
export default withNavigation(StudentLoginForm);
