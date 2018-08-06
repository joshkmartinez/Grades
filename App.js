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
      Arial: require("./app/resources/Arial.ttf"),
      Roboto: require("native-base/Fonts/Roboto.ttf"),
      Roboto_medium: require("native-base/Fonts/Roboto_medium.ttf")
    });

    this.setState({ fontLoaded: true });
  }
  render() {
    if (!this.state.fontLoaded) return <Text> Error loading font </Text>;
    return <Root />;
  }
  // ...
}
