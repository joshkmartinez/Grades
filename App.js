import React from "react";
import { Font } from "expo";
import { Text } from "react-native";
import { Root } from "./app/router";

export default class App extends React.Component {
  state = {
    fontLoaded: false
  };
  async componentDidMount() {
    await Font.loadAsync({
      Arial: require("./app/resources/Arial.ttf")
    });
    this.setState({ fontLoaded: true });
  }
  render() {
    if (!this.state.fontLoaded) return <Text> Error loading font </Text>;
    return <Root />;
  }
  // ...
}
