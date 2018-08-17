import React from "react";
import { Font } from "expo";
import { Text, View, ActivityIndicator } from "react-native";
import { Root } from "./app/router";

export default class App extends React.Component {
  state = {
    fontLoaded: false
  };
  async componentDidMount() {
    await Font.loadAsync({
      Arial: require("./app/resources/Arial.ttf"),
      Roboto: require("native-base/Fonts/Roboto.ttf"),
      Roboto_medium: require("native-base/Fonts/Roboto_medium.ttf"),
      FontAwesome: require("./node_modules/@expo/vector-icons/fonts/FontAwesome.ttf"),
      "Material Icons": require("./node_modules/@expo/vector-icons/fonts/MaterialIcons.ttf"),
      MaterialIcons: require("./node_modules/@expo/vector-icons/fonts/MaterialIcons.ttf")
    });
    this.setState({ fontLoaded: true });
  }
  render() {
    if (!this.state.fontLoaded)
      return (
        <View
          style={{
            top: 21,
            borderColor: "whitesmoke",
            alignItems: "center",
            justifyContent: "center"
          }}
        >
          <Text> Loading Fonts... </Text>
          <ActivityIndicator animating size="large" />
        </View>
      );
    return <Root />;
  }
  // ...
}
