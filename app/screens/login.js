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
import { Button, Text } from "native-base";
import { _ } from "lodash";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export default class Login extends React.Component {
  static navigationOptions = {
    title: "Login to Aeries"
  };

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
    this.showAlert = this.showAlert.bind(this);
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
      console.log("LOGIN FILE: no async LINK data exists");
      this.setState({ districtText: "Select a school before proceeding" });
    }
  }
  async checkIfSchoolNameExists() {
    if ((await AsyncStorage.getItem("name")) !== null) {
      //console.log("LOGIN FILE: async NAME data exists");
      const name = JSON.stringify(await AsyncStorage.getItem("name"));
      //console.log(name)
      this.setState({ districtText: name });
      //console.log("UPDATED school name STATE: " + this.state.schoolLink)
    } else {
      console.log("LOGIN FILE Check: no async NAME data exists");
    }
  }

  refreshSchoolandName = _.debounce(
    () => {
      this.checkIfLinkExists();
      this.checkIfSchoolNameExists();
    },
    420
    //this debounce function from lodash wont call the function until no editing has been made for 420 miliseconds (reduces api strain)
  );

  showAlert() {
    Alert.alert(
      "There was an error loging in. Please check your username and password and try again."
    );
  }
  auth() {
    console.log;
    this.setState({ authError: false, isAuthed: false, loading: true });

    if (
      this.state.isAuthed === false &&
      this.state.authError === false &&
      this.state.username !== null &&
      this.state.password !== null
    ) {
      // authentication is successful
      this.setState({ isAuthed: true });
      this.props.navigation.navigate("Grades");
    } else {
      // auth error
      this.setState({ authError: true, isAuthed: false });
      this.showAlert;
    }
  }

  render() {
    const { showAlert } = this.state;
    this.refreshSchoolandName();
    return (
      <View style={styles.wrapper}>
        <KeyboardAvoidingView
          behavior="padding"
          keyboardVerticalOffset={64}
          style={styles.loginContainer}
        >
          <View
            style={{
              flexDirection: "column",
              justifyContent: "center",
              alignItems: "center",
              margin: 3
            }}
          >
            <View
              style={{
                height: 6
              }}
            />{" "}
            //spacer
            <Button
              block
              info
              style={{ width: width - 73 }}
              onPress={() => this.props.navigation.navigate("chooseDistrict")}
            >
              <Text> Choose School / District </Text>
            </Button>
            <View
              style={{
                height: 3
              }}
            />{" "}
            //spacer
            <Text
              adjustsFontSizeToFit
              numberOfLines={1}
              style={styles.districtText}
            >
              {this.state.districtText.replace(/^"(.+(?="$))"$/, "$1")}{" "}
            </Text>
            //removes quotes from string
          </View>

          <TextInput
            placeholder="school email"
            keyboardType="email-address"
            autoCapitalize="none"
            autoCorrect={false}
            placeholderTextColor="white"
            style={styles.input}
            value={this.state.username}
          />

          <TextInput
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
              alignItems: "center",
              margin: 6
            }}
          >//spacer

            //the below Component shows ActivityIndicator if this.state.loading: true; else will show login button
            {this.state.loading ? (
              <ActivityIndicator animating size="large" />
            ) : (
              <Button
                primary
                onPress={() => this.props.navigation.navigate("Grades")}
              >
                <Text> Login </Text>
              </Button>
            )}
          </View>
        </KeyboardAvoidingView>
      </View>
    );
  }
}

const styles = {
  loginContainer: {
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    width: width - 42,
    backgroundColor: "#bdc3c7",
    borderRadius: 9,
    top: -9
  },

  districtText: { top: 1 },

  input: {
    paddingHorizontal: 10,
    color: "#2c3e50",
    backgroundColor: "#95a5a6",
    margin: 12,
    height: 42,
    width: width - 69,
    borderRadius: 3
  },

  logo: {
    width: 231,
    height: 231
  },

  wrapper: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
    marginTop: -21
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
