#!/usr/bin/env python3

import math
from functools import reduce


class Point(object):
    """AIM Point class."""

    def __init__(self, point=(0.0, 0.0)):
        self._x = int(point[0]) if int(point[0]) == float(point[0]) else float(point[0])
        self._y = int(point[1]) if int(point[1]) == float(point[1]) else float(point[1])

    def get_x(self):
        return self._x

    def get_y(self):
        return self._y

    def new_point(self, slope, distance):
        # slope is infinite
        if slope == "MAX":
            x2 = self.get_x()
            y2 = self.get_y() + distance
        # slope is 0
        elif slope == 0:
            x2 = self.get_x() + distance
            y2 = self.get_y()
        else:
            dx = round((distance / math.sqrt(1 + (slope ** 2))), 5)
            dy = slope * dx
            x2 = self.get_x() + dx
            y2 = self.get_y() + dy
        return Point(point=(x2, y2))

    def get_coordinates(self):
        return self.get_x(), self.get_y()


class Line(object):
    """AIM Line class."""

    def __init__(self, a: Point, b: Point):
        self._endpoint_a = a
        self._endpoint_b = b
        self._line_length = None
        self._line_slope = None
        self._perpendicular_slope = None

    def get_a(self):
        return self._endpoint_a

    def get_b(self):
        return self._endpoint_b

    def length(self):
        if self._line_length:
            return self._line_length
        dist_x = abs(self._endpoint_b.get_x() - self._endpoint_a.get_x())
        dist_y = abs(self._endpoint_b.get_y() - self._endpoint_a.get_y())
        dist_x_squared = dist_x ** 2
        dist_y_squared = dist_y ** 2
        self._line_length = math.sqrt(dist_x_squared + dist_y_squared)
        return self._line_length

    def slope(self):
        if self._line_slope:
            return self._line_slope
        run = self._endpoint_b.get_x() - self._endpoint_a.get_x()
        rise = self._endpoint_b.get_y() - self._endpoint_a.get_y()
        if run == 0:
            self._line_slope = "MAX"
        else:
            self._line_slope = rise / run
        return self._line_slope

    def perpendicular_slope(self):
        if self._perpendicular_slope:
            return self._perpendicular_slope
        if not self._line_slope:
            self.slope()
        if self._line_slope == "MAX":
            self._perpendicular_slope = 0
        elif self._line_slope == 0:
            self._perpendicular_slope = "MAX"
        else:
            self._perpendicular_slope = -1 / self._line_slope
        return self._perpendicular_slope

    def is_parallel(self, line):
        if not self._line_slope:
            self.slope()
        if self._line_slope == line.slope():
            return True
        return False

    def is_perpendicular(self, line):
        if self.perpendicular_slope() == line.slope():
            return True
        return False

    def length_equal(self, line):
        if self.length() == line.length():
            return True
        return False

    def slope_equal(self, line):
        if self.slope() == line.slope():
            return True
        return False

    def get_angle(self, line):
        # https://stackoverflow.com/questions/62195081/calculate-specific-angle-between-two-lines
        # Get directional vectors
        d1 = (self._endpoint_b.get_x() - self._endpoint_a.get_x(), self._endpoint_b.get_y() - self._endpoint_a.get_y())
        if self._endpoint_a.get_coordinates() == line.get_a().get_coordinates():
            d2 = (line.get_b().get_x() - line.get_a().get_x(), line.get_b().get_y() - line.get_a().get_y())
        else:
            d2 = (line.get_a().get_x() - line.get_b().get_x(), line.get_a().get_y() - line.get_b().get_y())
        # Compute dot product
        p = d1[0] * d2[0] + d1[1] * d2[1]
        # Compute norms
        n1 = round((math.sqrt(d1[0] * d1[0] + d1[1] * d1[1])), 5)
        n2 = round((math.sqrt(d2[0] * d2[0] + d2[1] * d2[1])), 5)
        # Rounding error causes this to go out of valid range
        base = (p / (n1 * n2))
        if abs(base) > 1:
            base = round(base, 4)
        # Compute angle
        ang = math.acos(base)
        # Convert to degrees if you want
        return round(math.degrees(ang), 5)


# noinspection SpellCheckingInspection,PyTypeChecker,PySetFunctionToLiteral,DuplicatedCode
class AIM(object):
    """AIM main class."""

    @staticmethod
    def find_quadrilateral(points: set, **kwargs) -> list:
        """Find quadrilateral."""
        """ This switches between different implentatins of the logic.  I did this for internal testing."""

        version = 3

        match version:
            case 1:
                return AIM.find_quadrilateral_version_1(points, **kwargs)
            case 2:
                return AIM.find_quadrilateral_version_2(points, **kwargs)
            case 3:
                return AIM.find_quadrilateral_version_3(points, **kwargs)
            case _:
                return AIM.find_quadrilateral_version_1(points, **kwargs)

    @staticmethod
    def find_quadrilateral_version_1(points: set, **kwargs) -> list:
        """Find quadrilateral."""
        """ Note: Shape definiopns: https://www.skillsyouneed.com/num/polygons.html
            Note: I did not see the same issue with sorting that was discovered with the rectangles, but I kept the
                   same logical flow just in case."""

        # No need to process points to remove duplicates. Sets do not allow duplicates

        def in_and_true(shape: str = None):
            if shape is not None and kwargs:
                if shape in kwargs:
                    return kwargs.get(shape)
            return False

        # Convert set to list to allow iteration with index and sort for processing simplicity
        points_list = list(points)
        # Define output dictionary
        output_dictionary = dict()
        for arg in kwargs:
            output_dictionary[arg] = list()
        # Iterate over list to find rectangle start points.
        for p1index in range(len(points_list)):
            # The iniatal point for the quadrilateral
            p1 = Point(point=points_list[p1index])
            for p2index in range(p1index + 1, len(points_list)):
                # The second point for the quadrilateral
                p2 = Point(point=points_list[p2index])
                # The first side for the quadrilateral
                l1 = Line(a=p1, b=p2)
                for p3index in range(p1index + 1, len(points_list)):
                    # The third point for the quadrilateral
                    p3 = Point(point=points_list[p3index])
                    # The second point for the quadrilateral
                    l2 = Line(a=p2, b=p3)
                    # These types can calculate potential p4, so they are grouped for efficiency
                    if any([in_and_true(shape) for shape in ["square", "rectangle", "parallelogram", "rhombus"]]):
                        # For the regualr quadrilaterals that have 2 sets of parallel sides, P4 has 2 possible
                        # positions, 1 valid and are invalid
                        possible_points = [p3.new_point(slope=l1.slope(), distance=l1.length()),
                                           p3.new_point(slope=l1.slope(), distance=-l1.length())]
                        # Itterate over possible_points to generate valid quadrilateral
                        for point in possible_points:
                            if point.get_coordinates() in points_list:
                                # Cordinates to use for quadrilateral
                                point_set = {points_list[p1index], points_list[p2index], points_list[p3index],
                                             point.get_coordinates()}
                                # A quadrilateral must have 4 points to generate
                                if len(point_set) != 4:
                                    continue
                                # These are the remaining 2 potential sides of the quadrilateral
                                l3 = Line(a=p3, b=point)
                                l4 = Line(a=point, b=p1)
                                # The sum of the inner angles of a quadrilateral must be 360 degrees
                                angle_list = [round(l1.get_angle(line=l2), 5), round(l2.get_angle(line=l3), 5),
                                              round(l3.get_angle(line=l4), 5), round(l4.get_angle(line=l1), 5)]
                                # If the angle between any 2 lines in 180,  then this will be colinnear
                                if 180 in angle_list:
                                    continue
                                # A quadrilateral requires the sum of the inner angles to be 360
                                if 360 != round(reduce(lambda x, y: x + y, angle_list), 3):
                                    continue
                                # Making a set to remove duplicate angles
                                angle_set = set(angle_list)
                                # Making a set to remove duplicate lengths
                                length_set = {round(l1.length(), 5), round(l2.length(), 5), round(l3.length(), 5),
                                              round(l4.length(), 5)}
                                # Determine the type of quadrilateral to process
                                if all([in_and_true("square"), len(angle_set) == 1, len(length_set) == 1]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("square").append(
                                        sorted(point_set, key=lambda x: (x[0], x[1])))
                                if all([in_and_true("rectangle"), len(angle_set) == 1, len(length_set) <= 2]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("rectangle").append(
                                        sorted(point_set, key=lambda x: (x[0], x[1])))
                                if all([in_and_true("parallelogram"), len(angle_set) <= 2, len(length_set) <= 2]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("parallelogram").append(
                                        sorted(point_set, key=lambda x: (x[0], x[1])))
                                if all([in_and_true("rhombus"), len(angle_set) <= 2, len(length_set) == 1]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("rhombus").append(
                                        sorted(point_set, key=lambda x: (x[0], x[1])))
                    # These types can not calculate potential p4, so they are grouped for efficiency
                    if any([in_and_true(shape) for shape in ["trapezoid", "isosceles_trapezoid", "kite", "irregular"]]):
                        for p4index in range(p1index + 1, len(points_list)):
                            # Cordinates to use for quadrilateral
                            point_set = {points_list[p1index], points_list[p2index], points_list[p3index],
                                         points_list[p4index]}
                            # A quadrilateral must have 4 points to generate
                            if len(point_set) != 4:
                                continue
                            # The forth point for the quadrilateral
                            p4 = Point(point=points_list[p4index])
                            # These are the remaining 2 potential sides of the quadrilateral
                            l3 = Line(a=p3, b=p4)
                            l4 = Line(a=p4, b=p1)
                            # The sum of the inner angles of a quadrilateral must be 360 degrees
                            angle_list = [round(l1.get_angle(line=l2), 5), round(l2.get_angle(line=l3), 5),
                                          round(l3.get_angle(line=l4), 5), round(l4.get_angle(line=l1), 5)]
                            # If the angle between any 2 lines in 180,  then this will be colinnear
                            if 180 in angle_list:
                                continue
                            # A quadrilateral requires the sum of the inner angles to be 360
                            if 360 != round(reduce(lambda x, y: x + y, angle_list), 3):
                                continue
                            # Making a set to remove duplicate angles
                            angle_set = set(angle_list)
                            # Making a set to remove duplicate lengths
                            length_set = {round(l1.length(), 5), round(l2.length(), 5), round(l3.length(), 5),
                                          round(l4.length(), 5)}
                            # Determine the type of quadrilateral to process
                            if all([in_and_true("trapezoid"), any([
                                all([l1.is_parallel(line=l3), l1.get_angle(line=l2) != l1.get_angle(line=l4),
                                     any([all([l1.get_angle(line=l4) <= 90, l1.get_angle(line=l2) <= 90]),
                                          all([l1.get_angle(line=l4) >= 90, l1.get_angle(line=l2) >= 90])])]),
                                all([l2.is_parallel(line=l4), l2.get_angle(line=l3) != l2.get_angle(line=l1),
                                     any([all([l2.get_angle(line=l3) <= 90, l2.get_angle(line=l1) <= 90]),
                                          all([l2.get_angle(line=l3) >= 90, l2.get_angle(line=l1) >= 90])])])])]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("trapezoid").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            if all([in_and_true("isosceles_trapezoid"), len(angle_set) == 2,
                                    any([all([l1.is_parallel(line=l3),
                                              any([all([l1.get_angle(line=l4) <= 90, l1.get_angle(line=l2) <= 90]),
                                                   all([l1.get_angle(line=l4) >= 90,
                                                        l1.get_angle(line=l2) >= 90])])]),
                                         all([l2.is_parallel(line=l4),
                                              any([all([l2.get_angle(line=l3) <= 90, l2.get_angle(line=l1) <= 90]),
                                                   all([l2.get_angle(line=l3) >= 90, l2.get_angle(line=l1) >= 90])])])
                                         ])
                                    ]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("isosceles_trapezoid").append(
                                    sorted(point_set, key=lambda x: (x[0], x[1])))
                            if all([in_and_true("kite"), len(set(angle_set)) <= 3, len(length_set) <= 2,
                                    any([l1.length_equal(line=l2), l1.length_equal(line=l4)])]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("kite").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            if all([in_and_true("irregular"), len(angle_set) == 4, len(length_set) == 4]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("irregular").append(sorted(point_set, key=lambda x: (x[0], x[1])))
        # Sort values and eliminate duplicates
        for key in output_dictionary:
            output_dictionary[key] = [list(x) for x in set(tuple(x) for x in output_dictionary.get(key))]
        return output_dictionary

    @staticmethod
    def find_quadrilateral_version_2(points: set, **kwargs) -> list:
        """Find quadrilateral."""
        """ Note: Shape definiopns: https://www.skillsyouneed.com/num/polygons.html
            Note: I did not see the same issue with sorting that was discovered with the rectangles, but I kept the
                   same logical flow just in case."""

        # No need to process points to remove duplicates. Sets do not allow duplicates

        def in_and_true(shape: str = None):
            if shape is not None and kwargs:
                if shape in kwargs:
                    return kwargs.get(shape)
            return False

        def validate():
            # A quadrilateral must have 4 points to generate
            if len(data.get("point_set")) != 4:
                return False
            # The sum of the inner angles of a quadrilateral must be 360 degrees
            data["angle_list"] = [round(data.get("l1").get_angle(line=data.get("l2")), 5),
                                  round(data.get("l2").get_angle(line=data.get("l3")), 5),
                                  round(data.get("l3").get_angle(line=data.get("l4")), 5),
                                  round(data.get("l4").get_angle(line=data.get("l1")), 5)]
            # If the angle between any 2 lines in 180, then this will be colinnear
            if 180 in data.get("angle_list"):
                return False
            # A quadrilateral requires the sum of the inner angles to be 360
            if 360 != round(reduce(lambda x, y: x + y, data.get("angle_list")), 3):
                return False
            # Making a set to remove duplicate angles
            data["angle_set"] = set(data.get("angle_list"))
            # Making a set to remove duplicate lengths
            data["length_set"] = {round(data.get("l1").length(), 5), round(data.get("l2").length(), 5),
                                  round(data.get("l3").length(), 5), round(data.get("l4").length(), 5)}
            return True

        # Convert set to list to allow iteration with index and sort for processing simplicity
        points_list = list(points)
        # Define data dictionary for central processing
        data = dict()
        # Define output dictionary
        output_dictionary = dict()
        for arg in kwargs:
            output_dictionary[arg] = list()
        # Iterate over list to find rectangle start points.
        for p1index in range(len(points_list)):
            # The iniatal point for the quadrilateral
            p1 = Point(point=points_list[p1index])
            for p2index in range(p1index + 1, len(points_list)):
                # The second point for the quadrilateral
                p2 = Point(point=points_list[p2index])
                # The first side for the quadrilateral
                data["l1"] = Line(a=p1, b=p2)
                for p3index in range(p1index + 1, len(points_list)):
                    # The third point for the quadrilateral
                    p3 = Point(point=points_list[p3index])
                    # The second point for the quadrilateral
                    data["l2"] = Line(a=p2, b=p3)
                    # These types can calculate potential p4, so they are grouped for efficiency
                    if any([in_and_true(shape) for shape in ["square", "rectangle", "parallelogram", "rhombus"]]):
                        # For the regualr quadrilaterals that have 2 sets of parallel sides, P4 has 2 possible
                        # positions, 1 valid and are invalid
                        data["possible_points"] = [
                            p3.new_point(slope=data.get("l1").slope(), distance=data.get("l1").length()),
                            p3.new_point(slope=data.get("l1").slope(), distance=-data.get("l1").length())]
                        # Itterate over possible_points to generate valid quadrilateral
                        for point in data.get("possible_points"):
                            if point.get_coordinates() in points_list:
                                # These are the remaining 2 potential sides of the quadrilateral
                                data["l3"] = Line(a=p3, b=point)
                                data["l4"] = Line(a=point, b=p1)
                                # Cordinates to use for quadrilateral
                                data["point_set"] = {points_list[p1index], points_list[p2index], points_list[p3index],
                                                     point.get_coordinates()}
                                # Perform validation
                                if not validate():
                                    continue
                                # Determine the type of quadrilateral to process
                                if all([in_and_true("square"), len(data.get("angle_set")) == 1,
                                        len(data.get("length_set")) == 1]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("square").append(
                                        sorted(data.get("point_set"), key=lambda x: (x[0], x[1])))
                                if all([in_and_true("rectangle"), len(data.get("angle_set")) == 1,
                                        len(data.get("length_set")) <= 2]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("rectangle").append(
                                        sorted(data.get("point_set"), key=lambda x: (x[0], x[1])))
                                if all([in_and_true("parallelogram"), len(data.get("angle_set")) <= 2,
                                        len(data.get("length_set")) <= 2]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("parallelogram").append(
                                        sorted(data.get("point_set"), key=lambda x: (x[0], x[1])))
                                if all([in_and_true("rhombus"), len(data.get("angle_set")) <= 2,
                                        len(data.get("length_set")) == 1]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("rhombus").append(
                                        sorted(data.get("point_set"), key=lambda x: (x[0], x[1])))
                    # These types can not calculate potential p4, so they are grouped for efficiency
                    if any([in_and_true(shape) for shape in ["trapezoid", "isosceles_trapezoid", "kite", "irregular"]]):
                        for p4index in range(p1index + 1, len(points_list)):
                            # The forth point for the quadrilateral
                            p4 = Point(point=points_list[p4index])
                            # These are the remaining 2 potential sides of the quadrilateral
                            data["l3"] = Line(a=p3, b=p4)
                            data["l4"] = Line(a=p4, b=p1)
                            # Cordinates to use for quadrilateral
                            data["point_set"] = {points_list[p1index], points_list[p2index], points_list[p3index],
                                                 points_list[p4index]}
                            # Perform validation
                            if not validate():
                                continue
                            # Determine the type of quadrilateral to process
                            if all([in_and_true("trapezoid"), any([
                                all([data.get("l1").is_parallel(line=data.get("l3")),
                                     data.get("l1").get_angle(line=data.get("l2")) != data.get("l1").get_angle(
                                         line=data.get("l4")),
                                     any([all([data.get("l1").get_angle(line=data.get("l4")) <= 90,
                                               data.get("l1").get_angle(line=data.get("l2")) <= 90]),
                                          all([data.get("l1").get_angle(line=data.get("l4")) >= 90,
                                               data.get("l1").get_angle(line=data.get("l2")) >= 90])])]),
                                all([data.get("l2").is_parallel(line=data.get("l4")),
                                     data.get("l2").get_angle(line=data.get("l3")) != data.get("l2").get_angle(
                                         line=data.get("l1")),
                                     any([all([data.get("l2").get_angle(line=data.get("l3")) <= 90,
                                               data.get("l2").get_angle(line=data.get("l1")) <= 90]),
                                          all([data.get("l2").get_angle(line=data.get("l3")) >= 90,
                                               data.get("l2").get_angle(line=data.get("l1")) >= 90])])])])]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("trapezoid").append(
                                    sorted(data.get("point_set"), key=lambda x: (x[0], x[1])))
                            if all([in_and_true("isosceles_trapezoid"), len(data.get("angle_set")) == 2,
                                    any([all([data.get("l1").is_parallel(line=data.get("l3")),
                                              any([all([data.get("l1").get_angle(line=data.get("l4")) <= 90,
                                                        data.get("l1").get_angle(line=data.get("l2")) <= 90]),
                                                   all([data.get("l1").get_angle(line=data.get("l4")) >= 90,
                                                        data.get("l1").get_angle(line=data.get("l2")) >= 90])])]),
                                         all([data.get("l2").is_parallel(line=data.get("l4")),
                                              any([all([data.get("l2").get_angle(line=data.get("l3")) <= 90,
                                                        data.get("l2").get_angle(line=data.get("l1")) <= 90]),
                                                   all([data.get("l2").get_angle(line=data.get("l3")) >= 90,
                                                        data.get("l2").get_angle(line=data.get("l1")) >= 90])])])
                                         ])
                                    ]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("isosceles_trapezoid").append(
                                    sorted(data.get("point_set"), key=lambda x: (x[0], x[1])))
                            if all([in_and_true("kite"), len(set(data.get("angle_set"))) <= 3,
                                    len(data.get("length_set")) <= 2,
                                    any([data.get("l1").length_equal(line=data.get("l2")),
                                         data.get("l1").length_equal(line=data.get("l4"))])]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("kite").append(
                                    sorted(data.get("point_set"), key=lambda x: (x[0], x[1])))
                            if all([in_and_true("irregular"), len(data.get("angle_set")) == 4,
                                    len(data.get("length_set")) == 4]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("irregular").append(
                                    sorted(data.get("point_set"), key=lambda x: (x[0], x[1])))
        # Sort values and eliminate duplicates
        for key in output_dictionary:
            output_dictionary[key] = [list(x) for x in set(tuple(x) for x in output_dictionary.get(key))]
        return output_dictionary

    @staticmethod
    def find_quadrilateral_version_3(points: set, **kwargs) -> list:
        """Find quadrilateral."""
        """ Note: Shape definiopns: https://www.skillsyouneed.com/num/polygons.html
            Note: I did not see the same issue with sorting that was discovered with the rectangles, but I kept the
                   same logical flow just in case."""

        # No need to process points to remove duplicates. Sets do not allow duplicates

        def in_and_true(shape: str = None):
            if shape is not None and kwargs:
                if shape in kwargs:
                    return kwargs.get(shape)
            return False

        def get(item: str):
            # This is used a lot, so I wanted the data access abstracted
            return data.get(item)

        def put(key: str, item):
            # This is used a lot, so I wanted the data access abstracted
            data[key] = item

        def set_length(item: str):
            # This is used a lot, so I wanted the data access abstracted
            return len(get(item=item))

        def validate():
            # A quadrilateral must have 4 points to generate
            if set_length(item="point_set") != 4:
                return False
            # The sum of the inner angles of a quadrilateral must be 360 degrees
            put(key="angle_list", item=[round(get(item="l1").get_angle(line=get(item="l2")), 5),
                                        round(get(item="l2").get_angle(line=get(item="l3")), 5),
                                        round(get(item="l3").get_angle(line=get(item="l4")), 5),
                                        round(get(item="l4").get_angle(line=get(item="l1")), 5)])
            # If the angle between any 2 lines in 180, then this will be colinnear
            if 180 in get(item="angle_list"):
                return False
            # A quadrilateral requires the sum of the inner angles to be 360
            if 360 != round(reduce(lambda x, y: x + y, get(item="angle_list")), 3):
                return False
            # Making a set to remove duplicate angles
            put(key="angle_set", item=set(get(item="angle_list")))
            # Making a set to remove duplicate lengths
            put(key="length_set", item={round(get(item="l1").length(), 5), round(get(item="l2").length(), 5),
                                        round(get(item="l3").length(), 5), round(get(item="l4").length(), 5)})
            return True

        def insert_point_set(point_set: set, shape: str = None, shape_list: list = None):
            # Test to see if the shape already has the points.  If so do not add.
            local_set = sorted(point_set, key=lambda x: (x[0], x[1]))
            if shape and local_set in output_dictionary[shape]:
                return False
            if shape_list:
                for shape in shape_list:
                    if not in_and_true(shape=shape):
                        continue
                    if shape and local_set in output_dictionary[shape]:
                        return False
            put(key="point_set", item=local_set)
            return True

        # Convert set to list to allow iteration with index and sort for processing simplicity
        points_list = list(points)
        # Define data dictionary for central processing
        data = dict()
        # groupings by numbers of points required to solve
        quadrilateral_2_points = ["square"]
        quadrilateral_3_points = ["rectangle", "parallelogram", "rhombus"]
        quadrilateral_4_points = ["trapezoid", "isosceles_trapezoid", "kite", "irregular"]
        # Define output dictionary
        output_dictionary = dict()
        for arg in kwargs:
            output_dictionary[arg] = list()
        # Iterate over list to find rectangle start points.
        for p1index in range(len(points_list)):
            # The iniatal point for the quadrilateral
            p1 = Point(point=points_list[p1index])
            for p2index in range(p1index + 1, len(points_list)):
                # The second point for the quadrilateral
                p2 = Point(point=points_list[p2index])
                # The first side for the quadrilateral
                put(key="l1", item=Line(a=p1, b=p2))
                # Shapes in this set can be derived with 2 points
                if any([in_and_true(shape) for shape in quadrilateral_2_points]):
                    shape = "square"
                    if in_and_true(shape):
                        # For the square, extend line to generate possible point sets
                        possible_points = (
                            (get(item="l1").get_b().new_point(slope=get(item="l1").perpendicular_slope(),
                                                              distance=get(item="l1").length()),
                             get(item="l1").get_a().new_point(slope=get(item="l1").perpendicular_slope(),
                                                              distance=get(item="l1").length())),
                            (get(item="l1").get_b().new_point(slope=get(item="l1").perpendicular_slope(),
                                                              distance=-get(item="l1").length()),
                             get(item="l1").get_a().new_point(slope=get(item="l1").perpendicular_slope(),
                                                              distance=-get(item="l1").length())))
                        # Itterate over possible_points to generate valid quadrilateral
                        for possible_point in possible_points:
                            # If possible point set does not exist in source point list, continue the loop
                            if not all(cordinate in points_list for cordinate in [possible_point[0].get_coordinates(),
                                                                                  possible_point[1].get_coordinates()]):
                                continue
                            # Cordinates to use for quadrilateral
                            # Test to see if the point set is already in the result set.  If it is not than proceed.
                            if insert_point_set(shape=shape, point_set={points_list[p1index], points_list[p2index],
                                                                        possible_point[0].get_coordinates(),
                                                                        possible_point[1].get_coordinates()}):
                                # Define remaining lines
                                put(key="l2", item=Line(a=p2, b=possible_point[0]))
                                put(key="l3", item=Line(a=possible_point[0], b=possible_point[1]))
                                put(key="l4", item=Line(a=possible_point[1], b=p1))
                                # Perform validation
                                if not validate():
                                    continue
                                if all([set_length(item="angle_set") == 1, set_length(item="length_set") == 1]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get(shape).append(get(item="point_set"))
                # Shapes in this set can not be derived with 2 points
                if any([in_and_true(shape) for shape in
                        quadrilateral_3_points + quadrilateral_4_points]):
                    for p3index in range(p1index + 1, len(points_list)):
                        # The third point for the quadrilateral
                        p3 = Point(point=points_list[p3index])
                        # The second point for the quadrilateral
                        put(key="l2", item=Line(a=p2, b=p3))
                        # These types can calculate potential p4, so they are grouped for efficiency
                        # Shapes in this set can be derived with 3 points
                        if any([in_and_true(shape) for shape in quadrilateral_3_points]):
                            # For the regualr quadrilaterals that have 2 sets of parallel sides, P4 has 2 possible
                            # positions, 1 valid and are invalid
                            put(key="possible_points", item=[
                                p3.new_point(slope=get(item="l1").slope(), distance=get(item="l1").length()),
                                p3.new_point(slope=get(item="l1").slope(),
                                             distance=-get(item="l1").length())])
                            # Itterate over possible_points to generate valid quadrilateral
                            for point in get(item="possible_points"):
                                if point.get_coordinates() in points_list:
                                    # These are the remaining 2 potential sides of the quadrilateral
                                    put(key="l3", item=Line(a=p3, b=point))
                                    put(key="l4", item=Line(a=point, b=p1))
                                    # Cordinates to use for quadrilateral
                                    # Test to see if the point set is already in the result set.  If it is not
                                    # than proceed.
                                    if insert_point_set(shape_list=quadrilateral_3_points,
                                                        point_set={points_list[p1index], points_list[p2index],
                                                                   points_list[p3index], point.get_coordinates()}):
                                        # Perform validation
                                        if not validate():
                                            continue
                                        # Determine the type of quadrilateral to process
                                        shape = "rectangle"
                                        if all([in_and_true(shape), set_length(item="angle_set") == 1,
                                                set_length(item="length_set") <= 2]):
                                            # If valid quadrilateral detected, append to output
                                            output_dictionary.get(shape).append(get(item="point_set"))
                                        shape = "parallelogram"
                                        if all([in_and_true(shape), set_length(item="angle_set") <= 2,
                                                set_length(item="length_set") <= 2]):
                                            # If valid quadrilateral detected, append to output
                                            output_dictionary.get(shape).append(get(item="point_set"))
                                        shape = "rhombus"
                                        if all([in_and_true(shape), set_length(item="angle_set") <= 2,
                                                set_length(item="length_set") == 1]):
                                            # If valid quadrilateral detected, append to output
                                            output_dictionary.get(shape).append(get(item="point_set"))
                        # These types can not calculate potential p4, so they are grouped for efficiency
                        # Shapes in this set can be derived with 4 points
                        if any([in_and_true(shape) for shape in quadrilateral_4_points]):
                            for p4index in range(p1index + 1, len(points_list)):
                                # The forth point for the quadrilateral
                                p4 = Point(point=points_list[p4index])
                                # These are the remaining 2 potential sides of the quadrilateral
                                put(key="l3", item=Line(a=p3, b=p4))
                                put(key="l4", item=Line(a=p4, b=p1))
                                # Cordinates to use for quadrilateral
                                # Test to see if the point set is already in the result set.  If it is not than proceed.
                                if insert_point_set(shape_list=quadrilateral_4_points,
                                                    point_set={points_list[p1index], points_list[p2index],
                                                               points_list[p3index], points_list[p4index]}):
                                    # Perform validation
                                    if not validate():
                                        continue
                                    # Determine the type of quadrilateral to process
                                    shape = "trapezoid"
                                    if all([in_and_true(shape), any([
                                        all([get(item="l1").is_parallel(line=get(item="l3")),
                                             get(item="l1").get_angle(line=get(item="l2")) != get(
                                                 item="l1").get_angle(
                                                 line=get(item="l4")),
                                             any([all([get(item="l1").get_angle(line=get(item="l4")) <= 90,
                                                       get(item="l1").get_angle(line=get(item="l2")) <= 90]),
                                                  all([get(item="l1").get_angle(line=get(item="l4")) >= 90,
                                                       get(item="l1").get_angle(
                                                           line=get(item="l2")) >= 90])])]),
                                        all([get(item="l2").is_parallel(line=get(item="l4")),
                                             get(item="l2").get_angle(line=get(item="l3")) != get(
                                                 item="l2").get_angle(
                                                 line=get(item="l1")),
                                             any([all([get(item="l2").get_angle(line=get(item="l3")) <= 90,
                                                       get(item="l2").get_angle(line=get(item="l1")) <= 90]),
                                                  all([get(item="l2").get_angle(line=get(item="l3")) >= 90,
                                                       get(item="l2").get_angle(
                                                           line=get(item="l1")) >= 90])])])])]):
                                        # If valid quadrilateral detected, append to output
                                        output_dictionary.get(shape).append(get(item="point_set"))
                                    shape = "isosceles_trapezoid"
                                    if all([in_and_true(shape), set_length(item="angle_set") == 2,
                                            any([all([get(item="l1").is_parallel(line=get(item="l3")),
                                                      any([all([get(item="l1").get_angle(
                                                          line=get(item="l4")) <= 90,
                                                                get(item="l1").get_angle(
                                                                    line=get(item="l2")) <= 90]),
                                                           all([get(item="l1").get_angle(
                                                               line=get(item="l4")) >= 90,
                                                                get(item="l1").get_angle(
                                                                    line=get(item="l2")) >= 90])])]),
                                                 all([get(item="l2").is_parallel(line=get(item="l4")),
                                                      any([all([get(item="l2").get_angle(
                                                          line=get(item="l3")) <= 90,
                                                                get(item="l2").get_angle(
                                                                    line=get(item="l1")) <= 90]),
                                                           all([get(item="l2").get_angle(
                                                               line=get(item="l3")) >= 90,
                                                                get(item="l2").get_angle(
                                                                    line=get(item="l1")) >= 90])])])
                                                 ])
                                            ]):
                                        # If valid quadrilateral detected, append to output
                                        output_dictionary.get(shape).append(get(item="point_set"))
                                    shape = "kite"
                                    if all([in_and_true(shape), set_length(item="angle_set") <= 3,
                                            set_length(item="length_set") <= 2,
                                            any([get(item="l1").length_equal(line=get(item="l2")),
                                                 get(item="l1").length_equal(line=get(item="l4"))])]):
                                        # If valid quadrilateral detected, append to output
                                        output_dictionary.get(shape).append(get(item="point_set"))
                                    shape = "irregular"
                                    if all([in_and_true(shape), set_length(item="angle_set") == 4,
                                            set_length(item="length_set") == 4]):
                                        # If valid quadrilateral detected, append to output
                                        output_dictionary.get(shape).append(get(item="point_set"))
        # Sort values and eliminate duplicates
        for shape in output_dictionary:
            output_dictionary[shape] = [list(x) for x in set(tuple(x) for x in output_dictionary.get(shape))]
        return output_dictionary

    @staticmethod
    def find_irregular_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               irregular quadrilaterals that can be formed from those points.
              Irregular quadrilateral are defined a four-sided shape where no sides are equal in length and no
               internal angles are the same. All internal angles still add up to 360°, as with all other
                regular quadrilaterals.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_irregular(points: set) -> list:
        """Find irregular."""
        results = AIM.find_quadrilateral(points=points, irregular=True)
        return results["irregular"]

    @staticmethod
    def find_kite_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               kite quadrilaterals that can be formed from those points.
              Kites are defined as having 4 sides, formed with 4 points. Two pairs of adjacent sides are of
               equal length; the shape has an axis of symmetry.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_kite(points: set) -> list:
        """Find kite."""
        results = AIM.find_quadrilateral(points=points, kite=True)
        return results["kite"]

    @staticmethod
    def find_isosceles_trapezoid_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               isosceles trapezoid quadrilaterals that can be formed from those points.
              Isosceles trapezoid are defined as having 4 sides, formed with 4 points. Two sides are parallel and
               base angles are equal, meaning that non-parallel sides are also equal in length.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_isosceles_trapezoid(points: set) -> list:
        """Find isosceles trapezoid."""
        results = AIM.find_quadrilateral(points=points, isosceles_trapezoid=True)
        return results["isosceles_trapezoid"]

    @staticmethod
    def find_trapezoid_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               trapezoid quadrilaterals that can be formed from those points.
              Trapezoid are defined as having 4 sides, formed with 4 points. Two sides are parallel, but the other
               two sides are not. Side lengths and angles are not equal.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_trapezoid(points: set) -> list:
        """Find trapezoid."""
        results = AIM.find_quadrilateral(points=points, trapezoid=True)
        return results["trapezoid"]

    @staticmethod
    def find_parallelogram_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               parallelograms that can be formed from those points.
              Parallelograms are defined as having 4 sides, formed with 4 points. Opposite sides are parallel,
               opposite sides are equal in length, opposite angles are equal.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_parallelogram(points: set) -> list:
        """Find parallelogram."""
        results = AIM.find_quadrilateral(points=points, parallelogram=True)
        return results["parallelogram"]

    @staticmethod
    def find_rhombus_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               rhombuses that can be formed from those points.
              Rhombuses are defined as having a special type of parallelogram in which all four sides are the
               same length, like a square that has been squashed sideways.
              Write a function find_rhombus that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique rhombuses that can be using those points
               as corners. The rhombuses do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_rhombus(points: set) -> list:
        """Find rhombuses."""
        results = AIM.find_quadrilateral(points=points, rhombus=True)
        return results["rhombus"]

    @staticmethod
    def find_rectangle_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct rectangles
               that can be formed from those points.
              Rectangles are defined as having 4 sides, formed with 4 points. Four internal right angles,
               opposite sides of equal length.
               Each corner must form a 90 degree angle.
              Write a function find_rectangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique rectangles that can be using those points
               as corners. The rectangles do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_rectangle(points: set) -> list:
        """Find rectangles."""
        results = AIM.find_quadrilateral(points=points, rectangle=True)
        return results["rectangle"]

    @staticmethod
    def find_square_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct squares
               that can be formed from those points.
              Squares are defined as having 4 sides, formed with 4 points. Four sides of equal length, four
               internal right angles.
              Write a function find_square that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique squares that can be using those points
               as corners. The squares do not need to be aligned with the x-y axes.
              For example, if points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3)}, then find_square(points)
               should return 2. As illustrated in the figure here (https://imgur.com/a/ygK9wfB), there are two
               squares that can be formed from these points: the blue diamond {(-3, 0), (0, -3), (3, 0), (0, 3)}
               and the green square {(0, 3), (3, 3), (3, 0), (0, 0)}.
              Make sure to give yourself enough time to implement a correct solution, then you can try to find
               solutions that have better asymptotic runtime.
              We are looking for production quality code, so please make sure your submission is clean and well
               documented. Also include any test cases you think would be helpful in validating correctness.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_square(points: set) -> list:
        """Find squares."""
        results = AIM.find_quadrilateral(points=points, square=True)
        return results["square"]

    @staticmethod
    def find_triangle_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              Triangles are defined as having 3 sides, formed with 3 non collinear points.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle(points: set, **kwargs) -> list:
        """Find triangles."""
        # No need to process points to remove duplicates. Sets do not allow duplicates
        """ Note: Shape definiopns: https://www.skillsyouneed.com/num/polygons.html
            Note: I did not see the same issue with sorting that was discovered with the rectangles, but I kept the
                   same logical flow just in case."""

        def in_and_true(key: str = None):
            if key is not None and kwargs:
                if key in kwargs:
                    return kwargs.get(key)
            return False

        # Convert set to list to allow iteration with index and sort for processing simplicity
        points_list = list(points)
        # Define output dictionary
        output_dictionary = dict()
        for arg in kwargs:
            output_dictionary[arg] = list()
        # Iterate over list to find rectangle start points.
        for p1index in range(len(points_list) - 2):
            # The iniatal point for the triangle
            p1 = Point(point=points_list[p1index])
            for p2index in range(p1index + 1, len(points_list) - 1):
                p2 = Point(point=points_list[p2index])
                # The second sided for the triangle
                l1 = Line(a=p1, b=p2)
                for p3index in range(p2index + 1, len(points_list)):
                    # Cordinates for the triangle points
                    point_set = {points_list[p1index], points_list[p2index], points_list[p3index]}
                    # A Triangle must have 3 points and not have adjacent lines be collinear
                    if len(point_set) != 3:
                        continue
                    # The third point of the triangle
                    p3 = Point(point=points_list[p3index])
                    # The remaining 2 sides of the triangle
                    l2 = Line(a=p2, b=p3)
                    l3 = Line(a=p3, b=p1)
                    # Calculated inner angles for the triangle
                    angle_list = [round(l1.get_angle(line=l2), 5), round(l2.get_angle(line=l3), 5),
                                  round(l3.get_angle(line=l1), 5)]
                    # If the inner angle between any 2 lines in 180, then this will be colinnear
                    if 180 in angle_list:
                        continue
                    # The sum of the inner angles of a triangle must be 180 degrees
                    if 180 != round(reduce(lambda x, y: x + y, angle_list), 3):
                        continue
                    # Making a set to remove duplicate angles
                    angle_set = set(angle_list)
                    # Making a set to remove duplicate lengths
                    length_set = {round(l1.length(), 5), round(l2.length(), 5), round(l3.length(), 5)}
                    if in_and_true("scalene"):
                        output_dictionary.get("scalene").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("acute"), all([True if angle < 90 else False for angle in angle_set])]):
                        output_dictionary.get("acute").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("obtuse"), any([True if angle > 90 else False for angle in angle_set])]):
                        output_dictionary.get("obtuse").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("right"), any([True if angle == 90 else False for angle in angle_set])]):
                        output_dictionary.get("right").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("isosceles"), len(length_set) <= 2]):
                        output_dictionary.get("isosceles").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("equilateral"), len(length_set) == 1]):
                        output_dictionary.get("equilateral").append(sorted(point_set, key=lambda x: (x[0], x[1])))
        # Sort values and eliminate duplicates
        for shape in output_dictionary:
            output_dictionary[shape] = [list(x) for x in set(tuple(x) for x in output_dictionary.get(shape))]
        return output_dictionary

    @staticmethod
    def find_triangle_scalene_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Scalene triangles are defined as having 3 sides, formed with 3 non collinear points. The 3 sides do not
               need to be the same length.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_scalene(points: set) -> list:
        """Find scalene triangles."""
        results = AIM.find_triangle(points=points, scalene=True)
        return results["scalene"]

    @staticmethod
    def find_triangle_acute_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Acute triangles are defined as having 3 sides, formed with 3 non collinear points. The 3 sides do not
               need to be the same length.  All angles must be less than 90 degrees.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_acute(points: set) -> list:
        """Find acute triangles."""
        results = AIM.find_triangle(points=points, acute=True)
        return results["acute"]

    @staticmethod
    def find_triangle_obtuse_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Obtuse triangles are defined as having 3 sides, formed with 3 non collinear points. The 3 sides do not
               need to be the same length.  1 angle must be greater than 90 degrees.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_obtuse(points: set) -> list:
        """Find obtuse triangles."""
        results = AIM.find_triangle(points=points, obtuse=True)
        return results["obtuse"]

    @staticmethod
    def find_triangle_right_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Right triangles are defined as having 3 sides, formed with 3 non collinear points. The 3 sides do not
               need to be the same length.  1 angle must be 90 degrees.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_right(points: set) -> list:
        """Find right triangles."""
        results = AIM.find_triangle(points=points, right=True)
        return results["right"]

    @staticmethod
    def find_triangle_isosceles_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Isosceles triangles are defined as having 3 sides, formed with 3 non collinear points. 2 sides must
               be the same length.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_isosceles(points: set) -> list:
        """Find isosceles triangles."""
        results = AIM.find_triangle(points=points, isosceles=True)
        return results["isosceles"]

    @staticmethod
    def find_triangle_equilateral_description():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Equilateral triangles are defined as having 3 sides, formed with 3 non collinear points. All 3 sides
               must be the same length.  All 3 angles must be equal.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_equilateral(points: set) -> list:
        """Find equilateral triangles."""
        results = AIM.find_triangle(points=points, equilateral=True)
        return results["equilateral"]
