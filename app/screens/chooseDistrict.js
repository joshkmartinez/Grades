import React from "react";
import { View, Text } from "react-native";

export default class chooseDistrict extends React.Component {
  static navigationOptions = {
    title: "Choose District"
  };
  render() {
    return (
      <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
        <Text>Home Screen</Text>
      </View>
    );
  }
}
