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
import { Button, Text, Toast, Root } from "native-base";
import { _ } from "lodash";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export default class Grades extends React.Component {
  static navigationOptions = {
    title: "Grades"
  };
  render() {
    return (
      <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
        <Text>Home Screen</Text>
      </View>
    );
  }
}
