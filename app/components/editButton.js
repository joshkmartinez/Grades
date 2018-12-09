import React from "react";
import {
  View,
  Dimensions,
  AsyncStorage,
  ActivityIndicator,
  TouchableOpacity,
  Alert
} from "react-native";
import { Text, Icon, Root, Spinner, Button } from "native-base";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

class EditButton extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  componentDidMount() {}
  DevAlert() {
    Alert.alert(
      "What-if Grade Calculator",
      "The What-if grade calculator feature is currently in development.",
      [
        {
          text: "Ok"
        }
      ],
      { cancelable: false }
    );
  }
  render() {
    return (
      <Root>
        <View>
          <TouchableOpacity
            onPress={() =>
              Alert.alert(
                "What-if Grade Calculator",
                "The What-if grade calculator feature is currently in development.",
                [
                  {
                    text: "Ok"
                  }
                ],
                { cancelable: false }
              )
            }
          >
            <Button transparent>
              <Icon type="FontAwesome" name="edit" />
            </Button>
          </TouchableOpacity>
        </View>
      </Root>
    );
  }
}

export default EditButton;
