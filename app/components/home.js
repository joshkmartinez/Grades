import React from "react";
import {
  View,
  TextInput,
  KeyboardAvoidingView,
  Dimensions,
  AsyncStorage,
  ActivityIndicator
} from "react-native";
import { Button, Text, Toast, Root } from "native-base";
import { _ } from "lodash";
import { withNavigation } from "react-navigation";
import PTRView from "react-native-pull-to-refresh";
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isAuthed: false,
      username: null,
      authError: false,
      password: null,
      districtText: "",
      schoolLink: "",
      loading: false
    };
    this.auth = this.auth.bind(this);
  }
  componentDidMount() {
    // make sure user has internet
    this.refreshSchoolandName();
  }

  async checkIfLinkExists() {
    if ((await AsyncStorage.getItem("link")) !== null) {
      //console.log("LOGIN FILE: async LINK data exists");
      const link = JSON.stringify(await AsyncStorage.getItem("link"));
      //console.log(link)

      this.setState({ schoolLink: link });

      //console.log("UPDATED LINK STATE: " + this.state.schoolLink)
    } else {
      console.log("LOGIN FILE: no async LINK data exists");
      this.setState({ districtText: "Select a school before proceeding" });
    }
  }
  async checkIfSchoolNameExists() {
    if ((await AsyncStorage.getItem("name")) !== null) {
      //console.log("LOGIN FILE: async NAME data exists");
      const name = JSON.stringify(await AsyncStorage.getItem("name"));
      //console.log(name)
      if (name !== this.state.districtText) {
        Toast.show({
          text: "School Chosen",
          buttonText: "Ok",
          duration: 3214, //in miliseconds
          position: "bottom",
          type: "success"
        });
      }
      this.setState({ districtText: name });
      //console.log("UPDATED school name STATE: " + this.state.schoolLink)
    } else {
      console.log("LOGIN FILE Check: no async NAME data exists");
    }
  }

  refreshSchoolandName = _.debounce(
    () => {
      this.checkIfLinkExists();
      this.checkIfSchoolNameExists();
    },
    420
    //this debounce function from lodash wont call the function until no editing has been made for 420 miliseconds (reduces api strain)
  );
  spacer(space) {
    return <View styles={{ height: space }} />;
  }
refresh(){
    
}
  auth() {
    console.log("auth function called");
    this.setState({ authError: false, isAuthed: false, loading: true });

    if (this.state.isAuthed === false && this.state.authError === false) {
      //try to auth
      //catch error code, check for internet fail code, check for invald auth code
      // authentication is successful
      console.log("in if state");
      this.setState({ isAuthed: true, loading: false });
      this.props.navigation.navigate("Grades");
    } else {
      // auth error
      this.setState({ isAuthed: false, loading: false });
      Toast.show({
        text: "Error...",
        buttonText: "Ok",
        duration: 3214, //in miliseconds
        position: "top",
        type: "danger"
      });
    }
  }

  render() {
    this.refreshSchoolandName();

    return (
      <Root>
        <PTRView onRefresh={this.refresh}>
        <View
          style={{ flex: 1, alignItems: "center", justifyContent: "center" }}
        >
          <Text>Logged in:</Text>
         
        
        
        </View>
      </PTRView>
      </Root>
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
    top: "12%"
  },};