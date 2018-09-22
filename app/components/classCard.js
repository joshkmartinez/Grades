import React from "react";
import PropTypes from "prop-types";
import {
  View,
  Dimensions,
  AsyncStorage,
  ActivityIndicator
} from "react-native";
import { BottomNavigation, Surface, Text } from "react-native-paper";
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export default class ClassCard extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
    this.auth = this.auth.bind(this);
  }
  componentDidMount() {
    //
  }
  static propTypes = {
    //className: PropTypes.string.isRequired
  };

  render() {
    return (
      <View>
        <Surface
          style={{
            padding: 8,
            backgroundColor: "#d50000",
            elevation: 3,
            justifyContent: "center",
            width: width - 21,

            height: height / 8 //divided by the number of classes you have, to a max of like 8, have a space at the bottom
          }}
        >
          <Text
            style={{
              textAlign: "right",
              alignSelf: "stretch",
              color: "white",
              top: 1,
              fontSize: responsiveFontSize(2.3)
            }}
          >
            95%
          </Text>
          <Text
            style={{
              textAlign: "left",
              color: "white",
              fontSize: responsiveFontSize(2.9)
            }}
          >
            AP Calculus
          </Text>
          <Text
            style={{
              textAlign: "right",
              alignSelf: "stretch",
              color: "white",
              fontSize: responsiveFontSize(2.3)
            }}
          >
            A+
          </Text>
        </Surface>
      </View>
    );
  }
}

const responsiveFontSize = f => {
  return Math.sqrt(height * height + width * width) * (f / 100);
};
