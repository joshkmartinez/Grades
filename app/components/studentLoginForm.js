import React from "react";
import {
  View,
  KeyboardAvoidingView,
  Dimensions,
  AsyncStorage,
  ActivityIndicator
} from "react-native";
import { Text, Toast, Root, Spinner } from "native-base";
import { _ } from "lodash";
import { withNavigation, Header } from "react-navigation";
import { ScrollView } from "react-native-gesture-handler";
import { Surface, TextInput, Button } from "react-native-paper";
import "url-search-params-polyfill";
import html2json from "html2json";
import axios from "axios";
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;
axios.interceptors.request.use(request => {
  console.log('Starting Request', request)
  return request
})

axios.interceptors.response.use(response => {
  console.log('Response:', response)
  return response
})
class StudentLoginForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isAuthed: false,
      username: "",
      authError: false,
      password: "",
      districtText: "",
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
    } else {
      //console.log("No saved login found");
    }
  }

  async saveLogin(username, password) {
    console.log("saving username and password");
    //console.log("the length of " + username + " is " + username.length);
    //console.log("the length of " + password + " is " + password.length);
    if (this.state.username.length > 3 && password.length > 3) {
      await AsyncStorage.setItem("username", username).catch(console.log);
      await AsyncStorage.setItem("password", password).catch(console.log);
      console.log("Login info saved for: " + username);
      /*
      if ((await AsyncStorage.getItem("username")) !== null) {
        console.log("async username data exists");
      } else {
        console.log("no async username data exists");
      }*/
    }
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

  async saveGrades(html) {
    //json = html2json(html.request._response);
    console.log("THIS IS SAVED: " +html.request._response);
    await AsyncStorage.setItem("grades", html.request._response).catch(console.log);
  }

  async needToUpdateGrades(yesorno) {
    await AsyncStorage.setItem("needToUpdateGrades", yesorno).catch(
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
    this.saveLogin(this.state.username, this.state.password);
    this.setState({ loading: true });
    // not supported on IOS - thats why I have url-search-params-polyfill
    const params = new URLSearchParams();
    params.append("checkCookiesEnabled", "true");
    params.append("checkMobileDevice", "false");
    params.append("checkStandaloneMode", "false");
    params.append("checkTabletDevice", "false");
    params.append(
      "portalAccountPassword",
      this.state.password.replace(/['"]+/g, "")
    );
    params.append(
      "portalAccountUsername",
      this.state.username.replace(/['"]+/g, "")
    );
    //these values are blank
    params.append("portalAccountUsernameLabel", "");
    params.append("submit", "");
    //console.log(params.toString())
    await axios
      .post(
        this.state.schoolLink.replace(/['"]+/g, "") +
          "/LoginParent.aspx?page=GradebookSummary.aspx",
        {
          params: {
            params
          },
          headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
            "Cache-Control":"max-age=0"
          },
          //the problem is sending the cookie
  withCredentials: true 
        }
      )
      .then(response => {
        //executed with response data
        //check if incorrect username / password <-parse for it
        this.saveGrades(response); //these dont work?
        this.needToUpdateGrades("yes"); // ^
        this.setState({ isAuthed: true, loading: false });
        this.saveAuthState("yes");
        console.log(response);
        this.props.navigation.navigate("Grades");
      })
      .catch(error => {
        // handle error
        console.log(error);
        this.setState({ isAuthed: false, loading: false });
        Toast.show({
          text: error.toString(),
          buttonText: "OK",
          duration: 3200, //in miliseconds
          position: "top",
          type: "danger"
        });
      })
      .then(() => {
        // always executed
      });
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
                {this.state.loading ? <Spinner color="blue" /> : <View />}
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
