import React from "react";
import {
  View,
  Image,
  TextInput,
  StyleSheet,
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
    this.state = { isAuthed: false };
    this.state = { username: "" };
    this.state = { authError: false };
    this.state = { password: "" };

    auth = () => {

      //do auth process
      this.setState({ authError: false });
      this.setState({ isAuthed: true });
      if (isAuthed === false) { // auth error
        this.setState({ authError: true });
        this.showAlert();
      }
      if (isAuthed === true) { // nav to grades screen is authentication is successful
        // save auth credentials
        this.props.navigation.navigate("Grades")
      }


    }

    const showAlert = () => {
      Alert.alert(
         'There was an error loging in. Please check your username and password and try again.'
      )
   }

  }
  render() {
    const {showAlert} = this.state
    return (
      <View style={styles.wrapper}>
        <KeyboardAvoidingView behavior="padding" style={styles.loginContainer}>
          <TextInput
            placeholder="school email"
            keyboardType="email-address"
            placeholderTextColor="white"
            style={styles.input}
            value={this.state.username}
          />

          <TextInput
            placeholder="password"
            secureTextEntry
            placeholderTextColor="white"
            style={styles.input}
            value={this.state.password}
          />

          <View style={{ alignItems: "center" }}>
            <Button
              primary
              onPress={showAlert}
              style={styles.loginButton}
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
    alignItems: "center",
    justifyContent: "center",
    width: width - 42,
    backgroundColor: "#bdc3c7",
    borderRadius: 9,
    marginTop: 21,
    marginBottom: 21
  },

  input: {
    paddingHorizontal: 10,
    marginTop: 9,
    marginBottom: 9,
    color: "#2c3e50",
    backgroundColor: "#95a5a6",
    margin: 3,
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
    color: 'red',
    textAlign: 'center',
  }
};
