import React from "react";
import {
  View,
  //TextInput,
  KeyboardAvoidingView,
  Dimensions,
  AsyncStorage,
  ActivityIndicator
} from "react-native";
import {  Text, Toast, Root, Spinner } from "native-base";
import { _ } from "lodash";
import { withNavigation, Header } from "react-navigation";
import { KeyboardAwareScrollView } from "react-native-keyboard-aware-scroll-view";
import { ScrollView } from "react-native-gesture-handler";
import { Surface, TextInput, Button } from "react-native-paper";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

class StudentLoginForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isAuthed: false,
      username: null,
      authError: false,
      password: null,
      districtText: "",
      schoolLink: "",
      loading: false
    };
    this.auth = this.auth.bind(this);
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

      //console.log("UPDATED LINK STATE: " + this.state.schoolLink)
    } else {
      console.log("School Link data does NOT exist");
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
          duration: 3214, //in miliseconds
          position: "bottom",
          type: "success"
        });
      }
      this.setState({ districtText: name });
      //console.log("UPDATED school name STATE: " + this.state.schoolLink)
    } else {
      console.log("School name is found");
    }
  }

  refreshSchoolandName = _.debounce(
    () => {
      this.checkIfLinkExists();
      this.checkIfSchoolNameExists();
    },
    333
    //this debounce function from lodash wont call the function until no editing has been made for 420 miliseconds (reduces api strain)
  );
  spacer(space) {
    return <View styles={{ height: space }} />;
  }
  //sleep / wait function
  sleep(milliseconds) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
      if (new Date().getTime() - start > milliseconds) {
        break;
      }
    }
  }

  auth() {
    console.log("auth function called");
    this.setState({ authError: false, isAuthed: false, loading: true });

    if (this.state.isAuthed === false && this.state.authError === false) {
      //try to auth
      //catch error code, check for internet fail code, check for invald auth code
      // authentication is successful
      console.log("first no error check");
      this.setState({ loading: true });

      //do things here

      this.setState({ isAuthed: true, loading: false });
      //this.sleep(1234)
      this.props.navigation.navigate("Grades");
    } else {
      // auth error
      this.setState({ isAuthed: false, loading: false });
      Toast.show({
        text: "Error...",
        buttonText: "Ok",
        duration: 3210, //in miliseconds
        position: "top",
        type: "danger"
      });
    }
  }

  render() {
    this.refreshSchoolandName();

    return (
      <Root>
        <View style={styles.wrapper}>
          <KeyboardAvoidingView
            behavior="padding"
            //keyboardVerticalOffset={0}
            style={styles.loginContainer}
          >
            <Surface
              style={{
                padding: 8,
                backgroundColor: "whitesmoke",
                alignItems: "center",
                justifyContent: "center",
                elevation: 9
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
                    alignItems: "center"
                  }}
                >
                  <Button
                    icon="search" mode="contained" color="whitesmoke"
                    style={{ width: width - 69 }}
                    onPress={() =>
                      this.props.navigation.navigate("chooseDistrict")
                    }
                  >
                    <Text> Choose School / District </Text>
                  </Button>
                </View>
                <View
                  style={{
                    height: 6
                  }}
                />
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
                <Button icon="check" mode="contained" color="whitesmoke" onPress={() => this.auth()}>
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
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    width: width - 42,
    backgroundColor: "whitesmoke",
    borderRadius: 9,
    top: "9%"
  },

  districtText: { top: 1 },

  input: {
    //backgroundColor: "#8499B1", //greyblue
    margin: 12, //height: 42,
    width: width - 69
  },

  wrapper: {
    alignItems: "center",
    justifyContent: "center"
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
