import React from "react";
import {
  View,
  Image,
  TextInput,
  StyleSheet,
  KeyboardAvoidingView,
  Dimensions
} from "react-native";
import { Button, Text } from "native-base";

const width = Dimensions.get("window").width;
const height = Dimensions.get("window").height;

export default class Login extends React.Component {
  static navigationOptions = {
    title: "Login to Aeries"
  };

  render() {
    return (
      <View style={styles.wrapper}>
        <KeyboardAvoidingView behavior="padding" style={styles.loginContainer}>
          <TextInput
            placeholder="school email"
            keyboardType="email-address"
            placeholderTextColor="white"
            style={styles.input}
          />

          <TextInput
            placeholder="password"
            secureTextEntry
            placeholderTextColor="white"
            style={styles.input}
          />

          <View style={{ alignItems: "center" }}>
            <Button
              primary
              onPress={() => this.props.navigation.navigate("Grades")}
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
  }
};
