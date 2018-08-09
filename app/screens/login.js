import React from "react";
import {
  View,
  TextInput,
  Alert,
  KeyboardAvoidingView,
  Dimensions
} from "react-native";
import { Button, Text } from "native-base";

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
      username: "",
      authError: false,
      password: "",
      districtText: ""
    };
    this.auth = this.auth.bind(this);
    this.showAlert = this.showAlert.bind(this);
  }
  showAlert() {
    Alert.alert(
      "There was an error loging in. Please check your username and password and try again."
    );
  }
  auth() {
    //do auth
    this.setState({ authError: false, isAuthed: false });

    if (
      this.state.isAuthed === false &&
      this.state.authError === false &&
      this.state.username == "admin" &&
      this.state.password == "admin"
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
              margin: 12
            }}
          >
            <Button
              block
              info
              style={{ width: width - 73 }}
              onPress={() => this.props.navigation.navigate("chooseDistrict")}
            >
              <Text> Choose School / District </Text>
            </Button>

            <Text style={styles.districtText}> {this.state.districtText} </Text>
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
              margin: 12
            }}
          >
            <Button
              primary
              onPress={() => this.props.navigation.navigate("Grades")}
            >
              <Text> Login </Text>
            </Button>
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

  districtText: {
    fontWeight: "bold"
  },

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
