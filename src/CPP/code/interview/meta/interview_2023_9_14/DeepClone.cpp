#pragma clang diagnostic push
#pragma ide diagnostic ignored "modernize-use-equals-default"
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

struct Data {
    int data;

    Data() : data(0) {}

    explicit Data(int x) : data(x) {}

    [[nodiscard]] string toString() const {
        return to_string(data);
    }
};

class V {
public:
    Data data_;
    std::vector<V *> edges_;

    explicit V(const Data &data) { data_ = data; }

    ~V() {/*... */}

    string toString() {
        string result = "(";
        result.append(data_.toString());
        result.append("{");
        if (!edges_.empty()) {
            result.append(edges_.at(0)->toString());
        }
        if (edges_.size() > 1) {
            for (int index = 1; index < edges_.size(); index++) {
                result.append(", ");
                result.append(edges_.at(index)->toString());
            }
        }
        result.append("}");
        result.append(")");
        return result;
    }
};

class G {
public:
    std::vector<V *> vertices_;

    string toString() {
        string result = "(";
        if (!vertices_.empty()) {
            result.append(vertices_.at(0)->toString());
        }
        if (vertices_.size() > 1) {
            for (int index = 1; index < vertices_.size(); index++) {
                result.append(", ");
                result.append(vertices_.at(index)->toString());
            }
        }
        result.append(")");
        return result;
    }

    ~G() {/*... */}
};

class DeepClone {
public:
    static void description() {
        cout << R"(DeepClone
    Given the following definition of a graph, implement a clone method which returns a deep clone of a given graph
        class V {
         public:
          V(const Data& data) { data_ = data; }
          Data data_;
          std::vector<V*> edges_;
        };

        class G {
         public:
          ~G() { ... }
          std::vector<V*> vertices_;
        };

        void clone(G& G1, G* G2) {
          // Your code here})" << endl;
    }

    static void clone(G &G1, G *G2) {
        for (auto vec: G1.vertices_) {
            // clone vec and add it to G2.vertices_
            G2->vertices_.push_back(cloneV(vec));
        }

    }

private:
    static V *cloneV(V *input) {
        V *me = new V(input->data_);
        me->data_ = Data(input->data_.data);
        for (auto edge: input->edges_) {
            me->edges_.push_back(cloneV(edge));
        }
        return me;
    }
};

#pragma clang diagnostic pop