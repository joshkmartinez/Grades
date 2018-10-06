import React from "react";
import {
  View,
  FlatList,
  ActivityIndicator,
  Dimensions,
  SafeAreaView,
  AsyncStorage,
  TouchableOpacity,
  Alert
} from "react-native";
import { List } from "react-native-elements";
import { Searchbar } from "react-native-paper";
import { Text, Root, Container } from "native-base";
import { _ } from "lodash";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export default class chooseDistrict extends React.Component {
  static navigationOptions = {
    title: "Choose School"
  };
  constructor(props) {
    super(props);
    this.makeRemoteRequest = this.makeRemoteRequest.bind(this);
    this.state = {
      loading: false,
      data: [],
      error: false,
      query: "",
      link: "",
      parsedQuery: "",
      hasChosenAlready: false
    };
    this.makeRemoteRequest = this.makeRemoteRequest.bind(this);
    this.parseQuery = this.parseQuery.bind(this);
    this.handleSearch = this.handleSearch.bind(this);
  }

  componentDidMount() {
    // make sure user has internet
  }

  makeRemoteRequest = _.debounce(
    () => {
      this.setState({ loading: true });
      console.log(this.state.query);
      let theQuery = this.state.query;
      let parsed = this.parseQuery(theQuery);
      console.log("Parsed query: " + parsed);
      this.setState({ parsedQuery: parsed });
      fetch(
        `https://ping.aeries.com/api/v1/schoolsearch/ca/AeriesAppParent/${parsed}`
      )
        .then(response => response.json())
        .then(responseJson => {
          console.log("Response: " + responseJson);
          this.setState(
            {
              isLoading: false,
              data: responseJson
            },
            function() {
              this.setState({ loading: false });
              //console.log("Current State: " + this.state.data);
            }
          );
        })
        .catch(error => {
          console.error(error);
          this.setState({ loading: false });
          this.setState({ error: true });
        });
    },
    //this debounce function from lodash wont call the function until no editing has been made for 250 miliseconds (reduces api strain)
    250
  );

  async storeData(link) {
    await AsyncStorage.setItem("link", link).catch(console.log);
    console.log("DATA SAVED: " + link);

    if ((await AsyncStorage.getItem("link")) !== null) {
      console.log("async link data exists");
    } else {
      console.log("no async link data exists");
    }
  }
  async storeSchoolName(name) {
    await AsyncStorage.setItem("name", name).catch(console.log);
    console.log("DATA SAVED: " + name);

    if ((await AsyncStorage.getItem("name")) !== null) {
      console.log("async name data exists");
    } else {
      console.log("no async name data exists");
    }
  }

  schoolSelected(link, name) {
    console.log("chosen link:" + link);
    console.log("the link length is:" + link.length);
    if (link.length !== 0) {
      this.storeData(link);
      this.storeSchoolName(name);
      this.props.navigation.navigate("Login");
    } else {
      console.log("school link is blank, cannot be chosen");
      Alert.alert(
        "Your school does not support the Aeries App",
        "Please contact your administration",
        [{ text: "OK", onPress: () => console.log("Link error acknowledged") }],
        { cancelable: false }
      );
    }
  }

  handleSearch = text => {
    this.setState({ query: text });
  };

  renderSeparator = () => {
    return (
      <View
        style={{
          height: 2,
          left: "9%",
          backgroundColor: "whitesmoke"
        }}
      />
    );
  };
  parseQuery(searchParam) {
    searchParam = searchParam.replace(/\s*$/, ""); //remove the whitespace after the string using regex
    searchParam = searchParam.split(" ").join("%20"); //STRINGS ARE IMMUTABLE
    //console.log("Function output:  " + searchParam);
    return searchParam;
    //have to replace spaces with %20 for the link
  }

  renderHeader = () => {
    return (
      <Searchbar
        lightTheme
        multiline={false}
        placeholder="Search for your school"
        onChangeText={query => this.setState({ query })}
        value={this.state.query}
        onEndEditing={this.makeRemoteRequest}
        style={{
          backgroundColor: "whitesmoke"
        }}
      />
    );
  };

  renderFooter = () => {
    if (!this.state.loading) return null;

    return (
      <View
        style={{
          paddingVertical: 9,
          borderTopWidth: 1,
          borderColor: "whitesmoke"
        }}
      >
        <ActivityIndicator animating size="large" />
      </View>
    );
  };
  render() {
    return (
      <Container>
        <Root>
          <SafeAreaView
            style={{ flex: 1, alignItems: "center", justifyContent: "center" }}
          >
            <List containerStyle={{ borderTopWidth: 0, borderBottomWidth: 0 }}>
              <FlatList
                style={{ width: width }}
                data={this.state.data}
                renderItem={({ item }) => (
                  <View style={{ left: "9%", padding: 6 }}>
                    <TouchableOpacity
                      onPress={() =>
                        this.schoolSelected(
                          item.AeriesAppParentURL,
                          item.SchoolName
                        )
                      }
                    >
                      <Text
                        style={{
                          fontSize: 16
                        }}
                      >
                        {item.SchoolName}
                      </Text>
                      <Text
                        style={{
                          fontSize: 12
                        }}
                      >
                        {item.DistrictName}
                      </Text>
                    </TouchableOpacity>
                  </View>
                )}
                //keyExtractor={item => item.AeriesAppParentURL}
                ItemSeparatorComponent={this.renderSeparator}
                ListHeaderComponent={this.renderHeader}
                ListFooterComponent={this.renderFooter}
              />
            </List>
          </SafeAreaView>
        </Root>
      </Container>
    );
  }
}
