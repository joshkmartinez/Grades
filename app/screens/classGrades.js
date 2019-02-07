import React from "react";
import {
  View,
  TouchableOpacity,
  Dimensions,
  AsyncStorage,
  ActivityIndicator,
  SafeAreaView,
  FlatList,
  Alert
} from "react-native";
//import { Button, Text, Toast, Root, Container } from "native-base";
import { _ } from "lodash";
import { List } from "react-native-elements";
import {
  BottomNavigation,
  Surface,
  Button,
  //List,
  Headline,
  Switch,
  Appbar
} from "react-native-paper";
import { withNavigation } from "react-navigation";
import { Text, Icon, Root } from "native-base";
import { default as EditButton } from "../components/editButton";
let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;
let colors = ["#e53935", "#fb8c00", "#43a047", "#1e88e5", "#8e24aa", "#6d4c41"];
export class classGrades extends React.Component {
  static navigationOptions = {
    title: "$ClassName - $%",
    gesturesEnabled: true,
    headerRight: (
      <TouchableOpacity
        style={{ alignItems: "center", justifyContent: "center" }}
        onPress={() =>
          Alert.alert(
            "What-if Grade Calculator",
            "This feature is currently in development.",
            [
              {
                text: "Ok"
              }
            ],
            { cancelable: false }
          )
        }
      >
        <View styles={{ alignItems: "center", justifyContent: "center" }}>
          <Text>✍️ </Text>
        </View>
      </TouchableOpacity>
    )
  };

  constructor(props) {
    super(props);
    this.state = {
      class: -1,
      assignments: "",
      ran: false,
      nums: "",
      all: "",
      data: [
        {
          name: "Vocabulary W/S",
          grade: 90,
          letterGrade: "A-",
          category: "Classwork",
          pointsEarned: 9,
          pointsOutOf: 10
        },
        {
          name: "Chapter 3 Reading Guide",
          grade: 100,
          letterGrade: "A+",
          category: "Homework",
          pointsEarned: 10,
          pointsOutOf: 10
        },
        {
          name: "Pop Quiz",
          grade: 80,
          letterGrade: "B-",
          category: "Tests",
          pointsEarned: 4,
          pointsOutOf: 5
        },
        {
          name: "Essay on this book",
          grade: 90,
          letterGrade: "A+",
          category: "Essays",
          pointsEarned: 100,
          pointsOutOf: 100
        },
        {
          name: "Group Presentation",
          grade: 100,
          letterGrade: "A-",
          category: "Classwork",
          pointsEarned: 50,
          pointsOutOf: 50
        },
        {
          name: "Characters W/S",
          grade: 95,
          letterGrade: "A-",
          category: "Classwork",
          pointsEarned: 19,
          pointsOutOf: 20
        },
        {
          name: "Vocabulary Test",
          grade: 98,
          letterGrade: "A+",
          category: "Test",
          pointsEarned: 98,
          pointsOutOf: 100
        },
        {
          name: "Book 3 Exam",
          grade: 100,
          letterGrade: "A+",
          category: "Tests/Quizes",
          pointsEarned: 50,
          pointsOutOf: 50
        },
        {
          name: "Really Long Pop Quiz with a super long name",
          grade: 95,
          letterGrade: "A",
          category: "Classwork",
          pointsEarned: 19,
          pointsOutOf: 20
        }
      ],
      loading: false
    };
  }
  componentDidMount() {
    {
      this.getAssignments();
    }
  }

  async getAll() {
    this.setState({
      all: JSON.parse(await AsyncStorage.getItem("all"))
    });
  }
  async getAssignments() {
    this.getAll();
    console.log(await AsyncStorage.getItem("all"));
    console.log("THIS IS ALL:   " + this.state.all);
  }

  componentWillMount() {}
  async makeRemoteRequest(i) {
    await this.getNumAss(
      (await AsyncStorage.getItem("gradebook#"))
        .substr(1)
        .slice(0, -1)
        .split(","),
      (await AsyncStorage.getItem("terms"))
        .substr(1)
        .slice(0, -1)
        .split(","),
      i
    );
  }

  handleRefresh = () => {
    this.setState({ loading: true });
    this.makeRemoteRequest();
  };

  renderSeparator = () => {
    return (
      <View>
        {/*<View
        style={{
          height: 1,
          width: "86%",
          backgroundColor: "#CED0CE",
          marginLeft: "14%"
        }}
      />*/}
      </View>
    );
  };
  async getNumAss(gn, t, i) {
    console.log("getting # of assignments");
    console.log(gn);
    console.log(i);
    console.log(gn[i]);
    console.log(this.state.class);
    var data = JSON.stringify({
      gradebookNumber: gn[i],
      term: t[i],
      pageSize: 0,
      requestedPage: 1
    });

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    handleRespsonse = async r => {
      console.log("RESPONSE:   " + r);
      this.setState({ nums: r });
      console.log(this.state.nums);
    };
    xhr.addEventListener("readystatechange", function() {
      if (this.readyState === this.DONE) {
        handleRespsonse(this.responseText);
      }
    });

    xhr.open(
      "POST",
      JSON.stringify(await AsyncStorage.getItem("link")).replace(/['"]+/g, "") +
        "/m/api/MobileWebAPI.asmx/GetGradebookDetailsData"
    );
    xhr.setRequestHeader("content-type", "application/json");

    xhr.send(data);
  }
  renderHeader = () => {
    return <View />;
  };

  classSelected = _.debounce(i => {
    if (!this.state.ran) {
      //run get i only once
      //i passed to the request is undefined
      this.setState({ class: i });
      this.setState({ ran: true });
    }
  }, 0);
  renderFooter = () => {
    if (!this.state.loading) return null;

    return (
      <View
        style={{
          paddingVertical: 20,
          borderTopWidth: 1
        }}
      >
        {/*<ActivityIndicator animating size="large" />*/}
      </View>
    );
  };
  render() {
    const { navigation } = this.props;
    const i = navigation.getParam("class", -1);
    this.classSelected(i);

    console.log("HERE IS I:   " + i + this.state.class);
    return (
      <Root
        styles={{ flex: 1, alignItems: "center", justifyContent: "center" }}
      >
        <SafeAreaView
          style={{ flex: 1, alignItems: "center", justifyContent: "center" }}
        >
          <List
            containerStyle={{
              borderTopWidth: 0,
              borderBottomWidth: 0,
              marginTop: 1,
              flex: 1,
              backgroundColor: "transparent"
            }}
          >
            <FlatList
              //style={{ width: width }}
              data={this.state.data}
              renderItem={({ item, index }) => (
                <Surface
                  style={{
                    margin: 3,
                    padding: 3,
                    backgroundColor: colors[index % colors.length],
                    //elevation: 3,
                    justifyContent: "center",
                    width: width - 9,
                    borderRadius: 3,

                    height: height / 12
                  }}
                >
                  <View
                    style={{
                      alignItems: "center",
                      flexDirection: "row",
                      flex: 1
                    }}
                  >
                    <View
                      style={{
                        //backgroundColor: "blue",
                        //height: 20,
                        width: width - width / 5
                        //justifyContent: "center",
                        //alignItems: "center",
                        //flexDirection: "row"
                      }}
                    >
                      <Text
                        ///adjustsFontSizeToFit
                        numberOfLines={1}
                        style={{
                          textAlign: "left",
                          alignSelf: "stretch",
                          color: "white",
                          //fontWeight: "bold",
                          fontSize: responsiveFontSize(1.89)
                        }}
                      >
                        {item.name}
                      </Text>
                      <Text
                        numberOfLines={1}
                        style={{
                          textAlign: "left",
                          alignSelf: "stretch",
                          color: "white",
                          fontSize: responsiveFontSize(1.5)
                        }}
                      >
                        {item.category}
                      </Text>
                    </View>

                    <View
                      style={{
                        //backgroundColor: "red",
                        alignItems: "flex-end",
                        flexDirection: "column",
                        justifyContent: "flex-end",
                        width: width / 7
                      }}
                    >
                      <Text
                        numberOfLines={1}
                        style={{
                          textAlign: "right",
                          alignSelf: "stretch",

                          color: "white",
                          //fontWeight: "bold",
                          fontSize: responsiveFontSize(1.5)
                        }}
                      >
                        {item.pointsEarned + "/" + item.pointsOutOf}
                      </Text>
                      <Text
                        style={{
                          textAlign: "right",
                          alignSelf: "stretch",
                          color: "white",
                          //fontWeight: "bold",
                          fontSize: responsiveFontSize(1.42)
                        }}
                      >
                        {item.letterGrade}
                      </Text>
                    </View>
                  </View>
                </Surface>
              )}
              ItemSeparatorComponent={this.renderSeparator}
              ListHeaderComponent={this.renderHeader}
              ListFooterComponent={this.renderFooter}
              keyExtractor={item => item.name}
              onRefresh={this.handleRefresh}
              refreshing={this.state.loading}
            />
          </List>
        </SafeAreaView>
      </Root>
    );
  }
}

const styles = {};
const responsiveFontSize = f => {
  return Math.sqrt(height * height + width * width) * (f / 100);
};
export default withNavigation(classGrades);
