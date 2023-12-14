package day8

object HauntedWasteland {
    fun getStepsRequired(input: String): Int {
        val parsedInput = parseInput(input)
        val graph = DirectedGraph()
        val directions = parsedInput.directions
        parsedInput.map.forEach { (key, value) ->
            graph.addNodeWithEdges(key, value.first, value.second)
        }
        return findSteps(graph, "AAA", "ZZZ", directions)
    }

    fun getStepsRequiredPart2(input: String): Long {
        val parsedInput = parseInput(input)
        val graph = DirectedGraph()
        val directions = parsedInput.directions
        parsedInput.map.forEach { (key, value) ->
            graph.addNodeWithEdges(key, value.first, value.second)
        }
        return findStepsPart2(graph, 'A', 'Z', directions)
    }

    private fun findStepsPart2(
        graph: DirectedGraph,
        startValue: Char,
        endValue: Char,
        directions: List<EdgeType>
    ): Long {
        val startTime = System.currentTimeMillis()
        return graph.findSteps(startValue, endValue, directions).also {
            println("Time taken ${(System.currentTimeMillis() - startTime)}")
        }
    }

    private fun findSteps(
        graph: DirectedGraph,
        startValue: String,
        endValue: String,
        directions: List<EdgeType>
    ): Int {
        return graph.findSteps(startValue, endValue, directions)
    }

    private fun parseInput(input: String): ParsedData {
        val lines = input.split("\n")
        val result = mutableMapOf<String, Pair<String, String>>()
        val directions = lines[0].split("").filter { it.isNotBlank() }.map {
            when (it) {
                "R" -> EdgeType.RIGHT
                "L" -> EdgeType.LEFT
                else -> throw IllegalArgumentException("Invalid direction $it")
            }
        }
        lines.drop(1).forEach { line ->
            if (line.isNotBlank()) {
                val (key, value) = line.split(" = ")
                val (leftValue, rightValue) = value.trim().trim('(', ')').split(", ")
                result[key] = Pair(leftValue, rightValue)
            }
        }
        return ParsedData(directions, result)
    }

    data class ParsedData(val directions: List<EdgeType>, val map: Map<String, Pair<String, String>>)

    enum class EdgeType { LEFT, RIGHT }

    class DirectedGraph {
        data class Node(val value: String) {
            var leftNode: Node? = null
            var rightNode: Node? = null
        }

        private val nodes: MutableMap<String, Node> = mutableMapOf()

        fun addNodeWithEdges(startValue: String, leftValue: String, rightValue: String) {
            addNode(startValue)
            addNode(leftValue)
            addNode(rightValue)
            addEdge(startValue, leftValue, EdgeType.LEFT)
            addEdge(startValue, rightValue, EdgeType.RIGHT)
        }

        private fun addNode(value: String) {
            if (!nodes.containsKey(value)) {
                nodes[value] = Node(value)
            }
        }

        private fun addEdge(fromValue: String, toValue: String, type: EdgeType) {
            val fromNode = nodes[fromValue] ?: throw IllegalArgumentException("Node $fromValue not found")
            val toNode = nodes[toValue] ?: throw IllegalArgumentException("Node $toValue not found")

            when (type) {
                EdgeType.LEFT -> {
                    fromNode.leftNode = toNode
                }

                EdgeType.RIGHT -> {
                    fromNode.rightNode = toNode
                }
            }
        }

        fun findSteps(startValue: String, endValue: String, directions: List<EdgeType>): Int {
            val startNode = nodes[startValue] ?: throw IllegalArgumentException("Node $startValue not found")
            nodes[endValue] ?: throw IllegalArgumentException("Node $endValue not found") // just to check
//            findRecursive(startNode, endValue, directions, 0) { totalStepsCount++ } // stack overflow on high volumes
            return findIterative(startNode, endValue, directions)
        }

        fun findSteps(startEndsIn: Char, endEndsIn: Char, directions: List<EdgeType>): Long {
            val startNodes = nodes.filter { it.key.endsWith(startEndsIn) }.map { it.value }.toSet()
            val endNodes = nodes.filter { it.key.endsWith(endEndsIn) }.map { it.value }.toSet()
            val counts = startNodes.map { startNode ->
                findIterative(startNode, endNodes, directions)
            }
            return lcm(counts)
        }

        private fun lcm(numbers: List<Long>): Long {
            return numbers.fold(1L) { lcm, number ->
                lcm * number / gcd(lcm, number)
            }
        }

        private fun gcd(a: Long, b: Long): Long {
            return if (b == 0L) a else gcd(b, a % b)
        }

        private fun findIterative(
            startNode: Node,
            endNodes: Set<Node>,
            directions: List<EdgeType>
        ): Long {
            var currentNode = startNode
            var directionIndex = 0
            var count = 0L

            while (endNodes.contains(currentNode).not()) {
                count++
                val nextDirectionIndex = (directionIndex + 1) % directions.size
                currentNode = when (directions[directionIndex]) {
                    EdgeType.LEFT -> currentNode.leftNode!!
                    EdgeType.RIGHT -> currentNode.rightNode!!
                }
                directionIndex = nextDirectionIndex
            }

            return count
        }

        private fun findIterative(
            startNode: Node,
            endValue: String,
            directions: List<EdgeType>
        ): Int {
            var currentNode = startNode
            var directionIndex = 0
            var count = 0
            while (currentNode.value != endValue) {
                count++
                val nextDirectionIndex = (directionIndex + 1) % directions.size
                currentNode = when (directions[directionIndex]) {
                    EdgeType.LEFT -> currentNode.leftNode!!
                    EdgeType.RIGHT -> currentNode.rightNode!!
                }
                directionIndex = nextDirectionIndex
            }
            return count
        }

        fun printGraph() {
            nodes.forEach { (key, value) ->
                println("Node $key: leftNode = ${value.leftNode?.value}, rightNode = ${value.rightNode?.value}")
            }
        }
    }

}