import React from "react";
import {
  View,
  FlatList,
  ActivityIndicator,
  Dimensions,
  SafeAreaView,
  AsyncStorage
} from "react-native";
import { List, SearchBar } from "react-native-elements";
import { Text } from "native-base";

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
    //this.makeRemoteRequest();
  }

  makeRemoteRequest = () => {
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
          console.log("Response: " + responseJson)
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
  };

  schoolSelected = link => {
    let schoolLink = this.state.link;
    _storeData = async () => {
      try {
        await AsyncStorage.setItem("Link", schoolLink);
        console.log("Data Saved!");
      } catch (error) {
        console.log("Error saving data");
      }
    };
  };

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
    searchParam = searchParam.split(" ").join("%20"); //STRINGS ARE IMMUTABLE
    console.log("Function output" + searchParam);
    return searchParam;
    //have to replace spaces with %20 for the link
  }

  renderHeader = () => {
    return (
      <SearchBar
        lightTheme
        multiline={false}
        placeholder="Search for your school"
        onChangeText={query => this.setState({ query })}
        value={this.state.query}
        onSubmitEditing={this.makeRemoteRequest}
        style={{ width: width, backgroundColor: "white" }}
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
      <SafeAreaView
        style={{ flex: 1, alignItems: "center", justifyContent: "center" }}
      >
        <List containerStyle={{ borderTopWidth: 0, borderBottomWidth: 0 }}>
          <FlatList
            style={{ width: width }}
            data={this.state.data}
            renderItem={({ item }) => (
              <View style={{ left: "9%", padding: 6 }}>
                <Text
                  style={{
                    fontSize: 16,
                    
                  }}
                >
                  {item.SchoolName}
                </Text>
                <Text
                  style={{
                    fontSize: 12,
                  }}
                >
                  {item.DistrictName} {item.DistrictName}
                </Text>
              </View>
            )}
            keyExtractor={item => item.SchoolName}
            ItemSeparatorComponent={this.renderSeparator}
            ListHeaderComponent={this.renderHeader}
            ListFooterComponent={this.renderFooter}
          />
        </List>
      </SafeAreaView>
    );
  }
}
