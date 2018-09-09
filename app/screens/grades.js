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
import PTRView from "react-native-pull-to-refresh";
import Tabbar from 'react-native-tabbar-bottom'

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export default class Grades extends React.Component {
  static navigationOptions = {
    title: "Grades"
  };
  constructor() {
    super()
    this.state = {
      page: "Home",
    }
  }


  refresh() {
      //get grades and repopulate tabs
      setTimeout(()=>{}, 2000)
   
  }

  render() {
    return (
      <Root>
      <PTRView onRefresh={this.refresh}>
        <View
          style={{ flex: 1, alignItems: "center", justifyContent: "center" }}
        >
          <Text>Logged in:</Text>
          {this.state.page === "Home" && <Text>show grades Component</Text>}
        {this.state.page === "Profile" && <Text>Profile Component</Text>}
        {this.state.page === "Settings" && <Text>Settings Component</Text>}
        
        
        </View>
      </PTRView>
      <Tabbar type="ripple" rippleColor="#007aff" tabbarBgColor="#78909c"
          stateFunc={(tab) => {
            this.setState({page: tab.page})
            //this.props.navigation.setParams({tabTitle: tab.title})
          }}
          activePage={this.state.page}
          tabs={[
            {
              page: "Home",
              //title: "HomeScreen", need to get this title to work
              icon: "home",
              badgeNumber: 1, //add new assignment notification number
            },
            
            {
              page: "Profile",
              icon: "person",
            },
            {
              page: "Settings",
              icon: "settings",
            },
          ]}
        />
      </Root>
    );
  }
}
