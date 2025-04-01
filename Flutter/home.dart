
import 'package:flutter/material.dart';
import 'cars.dart';
import 'architecture.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Wallpaper App')),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Expanded(
            child: Row(
              children: [
                Expanded(
                  child: GestureDetector(
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => CarsPage()),
                      );
                    },
                    child: Image.network(
                      'https://www.evoindia.com/h-upload/uid/vSCGKcMJaHpwHoHyxPheug1uIfuTjNIi.jpg',
                      fit: BoxFit.cover,
                    ),
                  ),
                ),
                Expanded(
                  child: GestureDetector(
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => ArchitecturePage()),
                      );
                    },
                    child: Image.network(
                      'https://parametric-architecture.com/wp-content/uploads/2023/02/Walt-Disney-Concert-Hall.jpg',
                      fit: BoxFit.cover,
                    ),
                  ),
                ),
              ],
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, '/cars');
                },
                child: Text('Cars'),
              ),
              ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, '/architecture');
                },
                child: Text('Architecture'),
              ),
            ],
          ),
          SizedBox(height: 20),
        ],
      ),
    );
  }
}
